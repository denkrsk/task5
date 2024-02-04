package com.example.demotest.service;

import com.example.demotest.app_query.*;
import com.example.demotest.model.Account_pool;
import com.example.demotest.model.Tpp_product;
import com.example.demotest.model.Tpp_product_register;
import com.example.demotest.model.Tpp_ref_product_register_type;
import com.example.demotest.repository.Account_poolRepository;
import com.example.demotest.repository.Tpp_productRepository;
import com.example.demotest.repository.Tpp_product_registerRepository;
import com.example.demotest.repository.Tpp_ref_product_register_typeRepository;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyService {
    // private final MyRepository myRepository;
    final private Tpp_product_registerRepository tppProductRegisterRepository;
    final private Tpp_ref_product_register_typeRepository tppRefProductRegisterTypeRepository;
    final private Account_poolRepository accountPoolRepository;
    final private Tpp_productRepository tppProductRepository;

    public Result processAccount(Account acc) {
        Result result = new Result();
        Tpp_product_register pr;
        try {
            acc.vaildateField();
            List<Tpp_product_register> prL = tppProductRegisterRepository.findEmployeesWithMoreThanSalary(acc.getInstanceId(), acc.getRegistryTypeCode());
            if (prL.isEmpty()) {
                System.out.println("Create new Tpp_product_register");
                Optional<Tpp_ref_product_register_type> tppRefProductRegisterType = tppRefProductRegisterTypeRepository.findByValue(acc.getRegistryTypeCode());
                if (tppRefProductRegisterType.isEmpty()) {
                    result.setStatus(3);
                    result.setMessage("Данные не найдены, Текст: КодПродукта  " + acc.getRegistryTypeCode() + " не найдено в Каталоге продуктов tppRefProductRegisterType для данного типа Регистра");
                    return result;
                }
                List<Account_pool> accountPools = accountPoolRepository.findAcc(acc.getBranchCode(), acc.getCurrencyCode(), acc.getPriorityCode(), acc.getRegistryTypeCode());
                Account_pool accountPool = accountPools.get(accountPools.size() - 1);
                System.out.println("accountPools = " + accountPools.size());
                pr = tppProductRegisterRepository.save(Tpp_product_register.builder().product_id(acc.getInstanceId()).type(acc.getRegistryTypeCode()).account_id(accountPool.getId()).currency_code(acc.getCurrencyCode()).build());
                ResAcc resAcc = new ResAcc(new Data(pr.getId()));
                result.setResAcc(resAcc);
                return result;
            } else {
                result.setStatus(2);
                result.setMessage("Ошибка! Параметр registryTypeCode тип регистра " + acc.getRegistryTypeCode() + " уже существует для ЭП с ИД " + acc.getInstanceId());
                return result;
            }
        } catch (IllegalArgumentException e) {

            result.setStatus(2);
            result.setMessage("Ошибка!!" + e.toString());
            return result;
        }
    }

    public Result processInstance(Instance instance) {
        Result result = new Result();
        Tpp_product pr = null;
        try {
            instance.vaildateField();

            Optional<Tpp_product> tppProduct = tppProductRepository.findByNumber(instance.getContractNumber());
            if (tppProduct.isPresent()) {
                System.out.println("Продукта нет!");
                result.setStatus(2);
                result.setMessage("Праметр № Дополнительного соглашения(сделки) Number " + instance.getContractNumber() + " уже существует для ЭП с ИД " + instance.getInstanceId());
                return result;
            }

            List<Tpp_ref_product_register_type> tppRefProductRegisterTypes = tppRefProductRegisterTypeRepository.findprt_Acctype(instance.getProductCode());
            if (tppRefProductRegisterTypes.isEmpty()) {
                result.setStatus(2);
                result.setMessage("Код продукта " + instance.getProductCode() + " не найдено в Каталоге продуктов");
                return result;
            }
            for (InstanceArrangement var : instance.getInstanceArrangementList()) {
                System.out.println("Выводим нумбер = " + var.getNumber());

                pr = tppProductRepository.save(Tpp_product.builder().client_id(Long.valueOf(instance.getMdmCode())).type(instance.getProductType()).number(var.getNumber()).priority((long) instance.getPriority()).start_date_time((Date) var.getOpeningDate()).end_date_time((Date) var.getClosingDate()).penalty_rate((long) instance.getInterestRatePenalty()).build());

            }
            ResInst resInst = new ResInst(new DataInst(pr.getId()));
            result.setResInst(resInst);
            return result;

        } catch (IllegalArgumentException e) {

            result.setStatus(2);
            result.setMessage("Ошибка!!" + e.toString());
            return result;
        }
    }
}
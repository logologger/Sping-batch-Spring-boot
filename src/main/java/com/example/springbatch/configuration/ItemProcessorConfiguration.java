package com.example.springbatch.configuration;

import com.example.springbatch.entity.Contract;
import com.example.springbatch.entity.ContractHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ItemProcessorConfiguration {

    private ObjectMapper mapper = new ObjectMapper();

    @Bean
    public ItemProcessor<Contract, ContractHistory> itemProcessor() {
        return  new ItemProcessor<Contract, ContractHistory>() {
            @Override
            public ContractHistory process(Contract contract) throws Exception {

                return mapper.convertValue(contract , ContractHistory.class);
            }
        };
    }
}

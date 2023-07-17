package com.cac.HomeBanking.api.mappers;

import com.cac.HomeBanking.api.dtos.TransferDto;
import com.cac.HomeBanking.domain.models.Transfer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public Transfer dtoToTransfer(TransferDto dto) {
        Transfer transfer = new Transfer();
        transfer.setDate(dto.getDate());
        transfer.setOrigin(dto.getOrigin());
        transfer.setTarget(dto.getTarget());
        transfer.setAmount(dto.getAmount());
        return transfer;
    }

    public TransferDto transferToDto(Transfer transfer) {
        TransferDto dto = new TransferDto();
        dto.setDate(transfer.getDate());
        dto.setOrigin(transfer.getOrigin());
        dto.setTarget(transfer.getTarget());
        dto.setAmount(transfer.getAmount());
        dto.setId(transfer.getId());
        return dto;
    }
}

package com.studying.MyProject.mapper;
import com.studying.MyProject.DTO.DocumentTypeDTO;
import com.studying.MyProject.entity.DocumentType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentTypeMapper {
    public DocumentTypeDTO toDTO (DocumentType documentType){
        DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
        documentTypeDTO.setName(documentType.getName());
        documentTypeDTO.setDescription(documentType.getDescription());
        return documentTypeDTO;
    }

    public List<DocumentTypeDTO> toDTOList (List<DocumentType> documentTypes){
        return documentTypes.stream().map(this::toDTO).toList();
    }
}

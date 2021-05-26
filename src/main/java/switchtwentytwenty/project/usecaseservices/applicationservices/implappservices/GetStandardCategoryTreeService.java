package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;

import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.List;

@Service
public class GetStandardCategoryTreeService implements IGetStandardCategoryTreeService {

    private final ICategoryRepository categoryRepository;
    private final CategoryDTODomainAssembler categoryDTODomainAssembler;

    public GetStandardCategoryTreeService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryDTODomainAssembler = new CategoryDTODomainAssembler();
    }

    public OutputCategoryTreeDTO getStandardCategoryTree(){
        List<Category> categoryList = categoryRepository.getStandardCategoryList();

        OutputCategoryTreeDTO outputCategoryTreeDTO = createStandardCategoryTreeDTO(categoryList);

        return outputCategoryTreeDTO;
    }

    private OutputCategoryTreeDTO createStandardCategoryTreeDTO(List<Category> categoryList){
        OutputCategoryTreeDTO outputCategoryTreeDTO = new OutputCategoryTreeDTO();

        for (Category category: categoryList) {
            OutputCategoryDTO outputCategoryDTO = categoryDTODomainAssembler.toDTO(category);
            outputCategoryTreeDTO.addOutputCategoryDTO(outputCategoryDTO);
        }

        return outputCategoryTreeDTO;
    }

}
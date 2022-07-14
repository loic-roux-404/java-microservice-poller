package fr.gamedev.question.category;

import fr.gamedev.core.restcommons.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryService extends AbstractCrudService<Category> {
    public CategoryService(
            @Autowired CategoryRepository userDisplayRepo
    ) {
        super(userDisplayRepo, CategoryConstants.URI);
    }
}

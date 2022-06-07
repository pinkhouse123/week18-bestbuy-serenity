package bestbuy.api.categoriesinfo;

import bestbuy.api.constants.EndPoints2;
import bestbuy.api.model.CategoryPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategoriesSteps {
    @Step("create category by name: {0} ,id : {1}")
    public ValidatableResponse createCategory(String name,String id){
        CategoryPojo categoryPojo= new CategoryPojo();
        categoryPojo.setName(name);
        categoryPojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoryPojo)
                .when()
                .post(EndPoints2.CREATE_CATEGORIES)
                .then();
    }
    @Step("getting single category by category id : {0}")
    public ValidatableResponse getSingleCategory(String id){
        return   SerenityRest.given().log().all()
                .pathParam("categoryID",id)
                .when()
                .get(EndPoints2.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }
    @Step("update category by name: {0} ,id : {1}")
    public ValidatableResponse updateCategory(String name,String id){
        CategoryPojo categoryPojo= new CategoryPojo();
        categoryPojo.setName(name);
        categoryPojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoryID",id)
                .body(categoryPojo)
                .when()
                .put(EndPoints2.UPDATE_CATEGORY_BY_ID)
                .then();
    }
    @Step("Deleting single category by category id : {0}")
    public ValidatableResponse deleteSingleCategory(String id){
        return   SerenityRest.given().log().all()
                .pathParam("categoryID",id)
                .when()
                .delete(EndPoints2.DELETE_CATEGORY_BY_ID)
                .then();
    }

}
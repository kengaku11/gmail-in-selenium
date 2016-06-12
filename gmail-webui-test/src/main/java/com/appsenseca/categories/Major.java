package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by Bryan on 6/12/2016.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Major.class})
public interface Major {

}

package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import java.util.Locale;

/**
 * Created by Bryan on 6/12/2016.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {


}

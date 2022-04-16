/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SuitePackage;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Łukasz
 */
@Suite.SuiteClasses({TestEntity.class, TestControl.class})
@RunWith(Categories.class)

public class AllTests {
    
}

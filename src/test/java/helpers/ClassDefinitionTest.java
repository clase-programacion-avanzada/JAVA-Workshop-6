package helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public abstract class ClassDefinitionTest {

    protected abstract String getClassName();
    protected abstract List<AttributeData> getExpectedAttributes();
    protected abstract Class[] getConstructorParameterTypes();

    @Test
    @Order(1)
    @DisplayName("Class is defined in the models package")
    void modelsPackageContainsClass() {
        try {
            Class.forName(getClassName());
        } catch (ClassNotFoundException e) {
            throw new AssertionError("The models package should contain a class named " + getClassName());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Class is defined with a constructor that initializes all attributes but not receives id")
    void classHasConstructorThatInitializesAllAttributesButId() {
        try {
            Class<?> clazz = Class.forName(getClassName());
            ClassDefinitionHelper definitionHelper = new ClassDefinitionHelper(clazz);
            definitionHelper.testConstructor(getConstructorParameterTypes());
        } catch (ClassNotFoundException e) {
            throw new AssertionError("The models package should contain a class named " + getClassName());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Class is defined with correct attributes")
    void classHasCorrectAttributes() {
        try {
            Class<?> clazz = Class.forName(getClassName());
            ClassDefinitionHelper definitionHelper = new ClassDefinitionHelper(clazz);
            definitionHelper.testAttributes(getExpectedAttributes());
        } catch (ClassNotFoundException e) {
            throw new AssertionError("The models package should contain a class named " + getClassName());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Class has getters for defined attributes")
    void classHasGettersForAllAttributes() {
        try {
            Class<?> clazz = Class.forName(getClassName());
            ClassDefinitionHelper definitionHelper = new ClassDefinitionHelper(clazz);
            definitionHelper.testGetters(getExpectedAttributes());
        } catch (ClassNotFoundException e) {
            throw new AssertionError("The models package should contain a class named " + getClassName());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Class has setters for defined attributes")
    void classHasSettersForAllAttributes() {
        try {
            Class<?> clazz = Class.forName(getClassName());
            ClassDefinitionHelper definitionHelper = new ClassDefinitionHelper(clazz);
            definitionHelper.testSetters(getExpectedAttributes().subList(1, getExpectedAttributes().size()));
        } catch (ClassNotFoundException e) {
            throw new AssertionError("The models package should contain a class named " + getClassName());
        }
    }
}
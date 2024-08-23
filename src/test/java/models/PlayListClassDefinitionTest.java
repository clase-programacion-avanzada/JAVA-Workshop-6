package models;

import helpers.AttributeData;
import helpers.ClassDefinitionHelper;
import helpers.ClassDefinitionTest;
import java.util.Arrays;
import java.util.List;

public class PlayListClassDefinitionTest extends ClassDefinitionTest {

    @Override
    protected String getClassName() {
        return "com.javeriana.models.PlayList";
    }

    @Override
    protected List<AttributeData> getExpectedAttributes() {
        return Arrays.asList(
            new AttributeData("id", "UUID", ClassDefinitionHelper.PRIVATE_MODIFIER),
            new AttributeData("name", "String", ClassDefinitionHelper.PRIVATE_MODIFIER)
        );
    }

    @Override
    protected List<Class[]> getConstructorParameterTypes() {
        return (List<Class[]>) List.of(new Class[]{String.class});
    }
}

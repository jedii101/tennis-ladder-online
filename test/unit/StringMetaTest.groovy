import org.apache.commons.lang.StringUtils

String.metaClass.mixin StringUtils

assert "Foo" == "foo".capitalize()
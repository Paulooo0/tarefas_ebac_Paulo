package br.com.pauloh.anotation;

import java.lang.annotation.*;

/**
 * @author rodrigo.pires
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
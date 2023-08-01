package com.spiritlight.collab.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to indicate that this field changes
 * at most once at runtime.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Stable {
}

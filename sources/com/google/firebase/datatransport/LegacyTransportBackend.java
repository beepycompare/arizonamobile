package com.google.firebase.datatransport;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.inject.Qualifier;
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Qualifier
/* loaded from: classes4.dex */
public @interface LegacyTransportBackend {
}

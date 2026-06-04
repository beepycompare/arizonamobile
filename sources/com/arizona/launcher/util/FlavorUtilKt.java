package com.arizona.launcher.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.ProjectType;
/* compiled from: FlavorUtil.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a3\u0010\u0006\u001a\u0002H\u0007\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n¢\u0006\u0002\u0010\f\u001a\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"isRodina", "", "isArizona", "isBrazil", "isDebug", "isStaging", "rodinaOrArizona", ExifInterface.GPS_DIRECTION_TRUE, "", "ifRodina", "Lkotlin/Function0;", "ifArizona", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getProjectType", "Lru/mrlargha/commonui/core/ProjectType;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlavorUtilKt {
    public static final boolean isArizona() {
        return true;
    }

    public static final boolean isBrazil() {
        return false;
    }

    public static final boolean isDebug() {
        return false;
    }

    public static final boolean isRodina() {
        return false;
    }

    public static final boolean isStaging() {
        return false;
    }

    public static final <T> T rodinaOrArizona(Function0<? extends T> ifRodina, Function0<? extends T> ifArizona) {
        Intrinsics.checkNotNullParameter(ifRodina, "ifRodina");
        Intrinsics.checkNotNullParameter(ifArizona, "ifArizona");
        return isRodina() ? ifRodina.invoke() : ifArizona.invoke();
    }

    public static final ProjectType getProjectType() {
        return (ProjectType) rodinaOrArizona(new Function0() { // from class: com.arizona.launcher.util.FlavorUtilKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProjectType projectType;
                projectType = ProjectType.RODINA;
                return projectType;
            }
        }, new Function0() { // from class: com.arizona.launcher.util.FlavorUtilKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProjectType projectType;
                projectType = ProjectType.ARIZONA;
                return projectType;
            }
        });
    }
}

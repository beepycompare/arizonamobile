package androidx.navigation.dynamicfeatures;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
/* compiled from: DynamicIncludeNavGraphBuilder.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\b\u001aH\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001d\b\u0002\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0012¢\u0006\u0002\b\u00130\u0010H\u0086\b\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001ad\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001d\b\u0002\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0012¢\u0006\u0002\b\u00130\u00102\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"includeDynamic", "", "Landroidx/navigation/dynamicfeatures/DynamicNavGraphBuilder;", "id", "", "moduleName", "", "graphResourceName", "builder", "Lkotlin/Function1;", "Landroidx/navigation/dynamicfeatures/DynamicIncludeNavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "route", ExifInterface.GPS_DIRECTION_TRUE, "", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "navigation-dynamic-features-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicIncludeNavGraphBuilderKt {
    @Deprecated(message = "Use routes to include your DynamicNavGraph instead", replaceWith = @ReplaceWith(expression = "includeDynamic(route = id.toString(), moduleName, graphResourceName) { builder.invoke() }", imports = {}))
    public static final void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i, String moduleName, String graphResourceName, Function1<? super DynamicIncludeNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicIncludeNavGraphBuilder dynamicIncludeNavGraphBuilder = new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), i, moduleName, graphResourceName);
        builder.invoke(dynamicIncludeNavGraphBuilder);
        dynamicNavGraphBuilder.destination(dynamicIncludeNavGraphBuilder);
    }

    public static /* synthetic */ void includeDynamic$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, String moduleName, String graphResourceName, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        Map typeMap = map;
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        dynamicNavGraphBuilder.destination(new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, moduleName, graphResourceName));
    }

    public static final void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, String route, String moduleName, String graphResourceName, Function1<? super DynamicIncludeNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicIncludeNavGraphBuilder dynamicIncludeNavGraphBuilder = new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), route, moduleName, graphResourceName);
        builder.invoke(dynamicIncludeNavGraphBuilder);
        dynamicNavGraphBuilder.destination(dynamicIncludeNavGraphBuilder);
    }

    public static /* synthetic */ void includeDynamic$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, String moduleName, String graphResourceName, Map map, Function1 builder, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        Map typeMap = map;
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicIncludeNavGraphBuilder dynamicIncludeNavGraphBuilder = new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, moduleName, graphResourceName);
        builder.invoke(dynamicIncludeNavGraphBuilder);
        dynamicNavGraphBuilder.destination(dynamicIncludeNavGraphBuilder);
    }

    public static final /* synthetic */ <T> void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, String moduleName, String graphResourceName, Map<KType, NavType<?>> typeMap, Function1<? super DynamicIncludeNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicIncludeNavGraphBuilder dynamicIncludeNavGraphBuilder = new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, moduleName, graphResourceName);
        builder.invoke(dynamicIncludeNavGraphBuilder);
        dynamicNavGraphBuilder.destination(dynamicIncludeNavGraphBuilder);
    }

    @Deprecated(message = "Use routes to include your DynamicNavGraph instead", replaceWith = @ReplaceWith(expression = "includeDynamic(route = id.toString(), moduleName, graphResourceName)", imports = {}))
    public static final void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i, String moduleName, String graphResourceName) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        dynamicNavGraphBuilder.destination(new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), i, moduleName, graphResourceName));
    }

    public static final void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, String route, String moduleName, String graphResourceName) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        dynamicNavGraphBuilder.destination(new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), route, moduleName, graphResourceName));
    }

    public static final /* synthetic */ <T> void includeDynamic(DynamicNavGraphBuilder dynamicNavGraphBuilder, String moduleName, String graphResourceName, Map<KType, NavType<?>> typeMap) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        dynamicNavGraphBuilder.destination(new DynamicIncludeNavGraphBuilder((DynamicIncludeGraphNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicIncludeGraphNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, moduleName, graphResourceName));
    }
}

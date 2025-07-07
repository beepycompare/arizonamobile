package androidx.navigation.dynamicfeatures;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavGraph;
import androidx.navigation.NavType;
import androidx.navigation.NavigatorProvider;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
/* compiled from: DynamicNavGraphBuilder.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\t*\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\t*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001ad\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\r2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u001d\b\u0002\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\u0010\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u000f2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a`\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00132\u000e\b\u0002\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u001d\b\u0002\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\u0010\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u000f2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a`\u0010\u0000\u001a\u00020\t\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u0013*\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\r2\u001d\b\u0002\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\u0010\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u000f2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\\\u0010\u0000\u001a\u00020\t\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u0013*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00132\u001d\b\u0002\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\u0010\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u000f2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"navigation", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Landroidx/navigation/dynamicfeatures/DynamicNavGraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "", "route", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "", ExifInterface.GPS_DIRECTION_TRUE, "navigation-dynamic-features-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicNavGraphBuilderKt {
    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, int i, int i2, Function1 builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    @Deprecated(message = "Use routes to create your DynamicNavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph navigation(NavigatorProvider navigatorProvider, int i, int i2, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    @Deprecated(message = "Use routes to create your DynamicNavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i, int i2, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(dynamicNavGraphBuilder.getProvider(), i, i2);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, String startDestination, String str, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, startDestination, str);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static final NavGraph navigation(NavigatorProvider navigatorProvider, String startDestination, String str, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, startDestination, str);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static final void navigation(DynamicNavGraphBuilder dynamicNavGraphBuilder, String startDestination, String route, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(dynamicNavGraphBuilder.getProvider(), startDestination, route);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, KClass startDestination, KClass kClass, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            kClass = null;
        }
        if ((i & 4) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, (KClass<?>) startDestination, (KClass<?>) kClass, (Map<KType, NavType<?>>) typeMap);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static final NavGraph navigation(NavigatorProvider navigatorProvider, KClass<?> startDestination, KClass<?> kClass, Map<KType, NavType<?>> typeMap, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, startDestination, kClass, typeMap);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, Object startDestination, KClass kClass, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            kClass = null;
        }
        if ((i & 4) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, startDestination, kClass, typeMap);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static final NavGraph navigation(NavigatorProvider navigatorProvider, Object startDestination, KClass<?> kClass, Map<KType, NavType<?>> typeMap, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicNavGraphBuilder dynamicNavGraphBuilder = new DynamicNavGraphBuilder(navigatorProvider, startDestination, kClass, typeMap);
        builder.invoke(dynamicNavGraphBuilder);
        return dynamicNavGraphBuilder.build();
    }

    public static /* synthetic */ void navigation$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, KClass startDestination, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        NavigatorProvider provider = dynamicNavGraphBuilder.getProvider();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(provider, (KClass<?>) startDestination, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) typeMap);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(DynamicNavGraphBuilder dynamicNavGraphBuilder, KClass<?> startDestination, Map<KType, NavType<?>> typeMap, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        NavigatorProvider provider = dynamicNavGraphBuilder.getProvider();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(provider, startDestination, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), typeMap);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }

    public static /* synthetic */ void navigation$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, Object startDestination, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        NavigatorProvider provider = dynamicNavGraphBuilder.getProvider();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(provider, startDestination, Reflection.getOrCreateKotlinClass(Object.class), typeMap);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(DynamicNavGraphBuilder dynamicNavGraphBuilder, Object startDestination, Map<KType, NavType<?>> typeMap, Function1<? super DynamicNavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        NavigatorProvider provider = dynamicNavGraphBuilder.getProvider();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = new DynamicNavGraphBuilder(provider, startDestination, Reflection.getOrCreateKotlinClass(Object.class), typeMap);
        builder.invoke(dynamicNavGraphBuilder2);
        dynamicNavGraphBuilder.destination(dynamicNavGraphBuilder2);
    }
}

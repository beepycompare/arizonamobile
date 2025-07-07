package androidx.navigation.dynamicfeatures.fragment;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavType;
import androidx.navigation.dynamicfeatures.DynamicNavGraphBuilder;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder;
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
/* compiled from: DynamicFragmentNavigatorDestinationBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0087\b\u001a?\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a!\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0086\b\u001a=\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aD\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\n\b\u0001\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\u00042\u001d\b\u0002\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0013¢\u0006\u0002\b\u00140\u0011H\u0086\b\u001a`\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\n\b\u0001\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\u00042\u001d\b\u0002\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0013¢\u0006\u0002\b\u00140\u00112\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\\\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u001d\b\u0002\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0013¢\u0006\u0002\b\u00140\u00112\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"fragment", "", "F", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/dynamicfeatures/DynamicNavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/dynamicfeatures/fragment/DynamicFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "fragmentClassName", "", "route", ExifInterface.GPS_DIRECTION_TRUE, "", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "navigation-dynamic-features-fragment_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicFragmentNavigatorDestinationBuilderKt {
    @Deprecated(message = "Use routes to create your DynamicFragmentDestination instead", replaceWith = @ReplaceWith(expression = "fragment(route = id.toString())", imports = {}))
    public static final /* synthetic */ <F extends Fragment> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = dynamicNavGraphBuilder;
        Intrinsics.reifiedOperationMarker(4, "F");
        dynamicNavGraphBuilder2.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) dynamicNavGraphBuilder2.getProvider().getNavigator(FragmentNavigator.class), i, Reflection.getOrCreateKotlinClass(Fragment.class)));
    }

    @Deprecated(message = "Use routes to create your DynamicFragmentDestination instead", replaceWith = @ReplaceWith(expression = "fragment(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final /* synthetic */ <F extends Fragment> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        String name = Fragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), i, name);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    @Deprecated(message = "Use routes to create your DynamicFragmentDestination instead", replaceWith = @ReplaceWith(expression = "fragment(route = id.toString(), fragmentClassName) { builder.invoke() }", imports = {}))
    public static final void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, int i, String fragmentClassName, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(fragmentClassName, "fragmentClassName");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), i, fragmentClassName);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, String route) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = dynamicNavGraphBuilder;
        Intrinsics.reifiedOperationMarker(4, "F");
        dynamicNavGraphBuilder2.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) dynamicNavGraphBuilder2.getProvider().getNavigator(FragmentNavigator.class), route, Reflection.getOrCreateKotlinClass(Fragment.class)));
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, String route, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        String name = Fragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), route, name);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static final void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, String route, String fragmentClassName, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(fragmentClassName, "fragmentClassName");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), route, fragmentClassName);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void fragment$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, Map typeMap, int i, Object obj) {
        if ((i & 1) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = dynamicNavGraphBuilder;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "F");
        dynamicNavGraphBuilder2.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) dynamicNavGraphBuilder2.getProvider().getNavigator(FragmentNavigator.class), orCreateKotlinClass, typeMap, Reflection.getOrCreateKotlinClass(Fragment.class)));
    }

    public static final /* synthetic */ <F extends Fragment, T> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, Map<KType, NavType<?>> typeMap) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        DynamicNavGraphBuilder dynamicNavGraphBuilder2 = dynamicNavGraphBuilder;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "F");
        dynamicNavGraphBuilder2.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) dynamicNavGraphBuilder2.getProvider().getNavigator(FragmentNavigator.class), orCreateKotlinClass, typeMap, Reflection.getOrCreateKotlinClass(Fragment.class)));
    }

    public static /* synthetic */ void fragment$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 1) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        String name = Fragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, name);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment, T> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, Map<KType, NavType<?>> typeMap, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        String name = Fragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, name);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void fragment$default(DynamicNavGraphBuilder dynamicNavGraphBuilder, String fragmentClassName, Map typeMap, Function1 builder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(fragmentClassName, "fragmentClassName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, fragmentClassName);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <T> void fragment(DynamicNavGraphBuilder dynamicNavGraphBuilder, String fragmentClassName, Map<KType, NavType<?>> typeMap, Function1<? super DynamicFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(dynamicNavGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(fragmentClassName, "fragmentClassName");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        DynamicFragmentNavigatorDestinationBuilder dynamicFragmentNavigatorDestinationBuilder = new DynamicFragmentNavigatorDestinationBuilder((DynamicFragmentNavigator) dynamicNavGraphBuilder.getProvider().getNavigator(DynamicFragmentNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), typeMap, fragmentClassName);
        builder.invoke(dynamicFragmentNavigatorDestinationBuilder);
        dynamicNavGraphBuilder.destination(dynamicFragmentNavigatorDestinationBuilder);
    }
}

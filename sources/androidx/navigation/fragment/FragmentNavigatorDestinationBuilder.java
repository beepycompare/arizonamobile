package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.NavType;
import androidx.navigation.fragment.FragmentNavigator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
/* compiled from: FragmentNavigatorDestinationBuilder.kt */
@NavDestinationDsl
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000eBN\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\b\u0012\u001b\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0013¢\u0006\u0002\b\u00140\u0011\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "navigator", "Landroidx/navigation/fragment/FragmentNavigator;", "id", "", "fragmentClass", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/navigation/fragment/FragmentNavigator;ILkotlin/reflect/KClass;)V", "route", "", "(Landroidx/navigation/fragment/FragmentNavigator;Ljava/lang/String;Lkotlin/reflect/KClass;)V", "", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/navigation/fragment/FragmentNavigator;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/reflect/KClass;)V", "build", "navigation-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FragmentNavigatorDestinationBuilder extends NavDestinationBuilder<FragmentNavigator.Destination> {
    private KClass<? extends Fragment> fragmentClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your FragmentNavigatorDestination instead", replaceWith = @ReplaceWith(expression = "FragmentNavigatorDestinationBuilder(navigator, route = id.toString(), fragmentClass) ", imports = {}))
    public FragmentNavigatorDestinationBuilder(FragmentNavigator navigator, int i, KClass<? extends Fragment> fragmentClass) {
        super(navigator, i);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(FragmentNavigator navigator, String route, KClass<? extends Fragment> fragmentClass) {
        super(navigator, route);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(FragmentNavigator navigator, KClass<? extends Object> route, Map<KType, NavType<?>> typeMap, KClass<? extends Fragment> fragmentClass) {
        super(navigator, route, typeMap);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public FragmentNavigator.Destination build() {
        FragmentNavigator.Destination destination = (FragmentNavigator.Destination) super.build();
        String name = JvmClassMappingKt.getJavaClass((KClass) this.fragmentClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        destination.setClassName(name);
        return destination;
    }
}

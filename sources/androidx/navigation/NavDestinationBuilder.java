package androidx.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
/* compiled from: NavDestinationBuilder.android.kt */
@NavDestinationDsl
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B-\b\u0000\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB#\b\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fB#\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\rBD\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u0012\u001b\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0012¢\u0006\u0002\b\u00130\u0010¢\u0006\u0004\b\n\u0010\u0014J'\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020%0(¢\u0006\u0002\b*J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\tJ\"\u0010.\u001a\u00020%\"\n\b\u0001\u00100\u0018\u0001*\u00020\u00032\u0006\u00101\u001a\u00020\tH\u0087\b¢\u0006\u0002\b2J\u001f\u0010.\u001a\u00020%2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020%0(¢\u0006\u0002\b*J;\u0010.\u001a\u00020%\"\n\b\u0001\u00100\u0018\u0001*\u00020\u00032\u0006\u00101\u001a\u00020\t2\u0019\b\b\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020%0(¢\u0006\u0002\b*H\u0086\bø\u0001\u0000J?\u0010.\u001a\u00020%\"\b\b\u0001\u00100*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H00\u000e2\u0006\u00101\u001a\u00020\t2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020%0(¢\u0006\u0002\b*J\u000e\u0010.\u001a\u00020%2\u0006\u00103\u001a\u00020-J)\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u00072\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020%0(¢\u0006\u0002\b*H\u0007J\r\u0010;\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010<J\r\u0010=\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010<R\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\"X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006>"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "D", "Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "id", "", "route", "", "<init>", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "(Landroidx/navigation/Navigator;I)V", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/navigation/Navigator;Lkotlin/reflect/KClass;Ljava/util/Map;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "getId", "()I", "getRoute", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "arguments", "", "Landroidx/navigation/NavArgument;", "argument", "", "name", "argumentBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "Lkotlin/ExtensionFunctionType;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "deepLink", "uriPattern", ExifInterface.GPS_DIRECTION_TRUE, "basePath", "deepLinkSafeArgs", "navDeepLink", "Landroidx/navigation/NavDeepLinkDslBuilder;", "actions", "Landroidx/navigation/NavAction;", "action", "actionId", "actionBuilder", "Landroidx/navigation/NavActionBuilder;", "instantiateDestination", "()Landroidx/navigation/NavDestination;", "build", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;
    private Map<KType, ? extends NavType<?>> typeMap;

    public NavDestinationBuilder(Navigator<? extends D> navigator, int i, String str) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        this.navigator = navigator;
        this.id = i;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    protected final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final int getId() {
        return this.id;
    }

    public final String getRoute() {
        return this.route;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your NavDestination instead", replaceWith = @ReplaceWith(expression = "NavDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public NavDestinationBuilder(Navigator<? extends D> navigator, int i) {
        this(navigator, i, (String) null);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(Navigator<? extends D> navigator, String str) {
        this(navigator, -1, str);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavDestinationBuilder(Navigator<? extends D> navigator, KClass<?> kClass, Map<KType, NavType<?>> typeMap) {
        this(navigator, r0, r1);
        KSerializer serializer;
        KSerializer serializer2;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        int generateHashCode = (kClass == null || (serializer2 = SerializersKt.serializer(kClass)) == null) ? -1 : RouteSerializerKt.generateHashCode(serializer2);
        String str = null;
        if (kClass != null && (serializer = SerializersKt.serializer(kClass)) != null) {
            str = RouteSerializerKt.generateRoutePattern$default(serializer, typeMap, null, 2, null);
        }
        if (kClass != null) {
            for (NamedNavArgument namedNavArgument : RouteSerializerKt.generateNavArguments(SerializersKt.serializer(kClass), typeMap)) {
                this.arguments.put(namedNavArgument.getName(), namedNavArgument.getArgument());
            }
        }
        this.typeMap = typeMap;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void argument(String name, Function1<? super NavArgumentBuilder, Unit> argumentBuilder) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argumentBuilder, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        argumentBuilder.invoke(navArgumentBuilder);
        map.put(name, navArgumentBuilder.build());
    }

    public final void argument(String name, NavArgument argument) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.arguments.put(name, argument);
    }

    public final void deepLink(String uriPattern) {
        Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
        this.deepLinks.add(new NavDeepLink(uriPattern));
    }

    public final /* synthetic */ <T> void deepLinkSafeArgs(String basePath) {
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        deepLink(Reflection.getOrCreateKotlinClass(Object.class), basePath, new Function1<NavDeepLinkDslBuilder, Unit>() { // from class: androidx.navigation.NavDestinationBuilder$deepLink$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(NavDeepLinkDslBuilder deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "$this$deepLink");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavDeepLinkDslBuilder navDeepLinkDslBuilder) {
                invoke2(navDeepLinkDslBuilder);
                return Unit.INSTANCE;
            }
        });
    }

    public final void deepLink(Function1<? super NavDeepLinkDslBuilder, Unit> navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        List<NavDeepLink> list = this.deepLinks;
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        navDeepLink.invoke(navDeepLinkDslBuilder);
        list.add(navDeepLinkDslBuilder.build$navigation_common_release());
    }

    public final /* synthetic */ <T> void deepLink(String basePath, Function1<? super NavDeepLinkDslBuilder, Unit> navDeepLink) {
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        deepLink(Reflection.getOrCreateKotlinClass(Object.class), basePath, navDeepLink);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> void deepLink(KClass<T> route, String basePath, Function1<? super NavDeepLinkDslBuilder, Unit> navDeepLink) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        if (this.typeMap == null) {
            throw new IllegalStateException(("Cannot add deeplink from KClass [" + route + "]. Use the NavDestinationBuilder constructor that takes a KClass with the same arguments.").toString());
        }
        KSerializer serializer = SerializersKt.serializer(route);
        Map<KType, ? extends NavType<?>> map = this.typeMap;
        Map<KType, ? extends NavType<?>> map2 = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeMap");
            map = null;
        }
        for (NamedNavArgument namedNavArgument : RouteSerializerKt.generateNavArguments(serializer, map)) {
            NavArgument navArgument = this.arguments.get(namedNavArgument.getName());
            if (navArgument == null || !Intrinsics.areEqual(navArgument.getType(), namedNavArgument.getArgument().getType())) {
                throw new IllegalArgumentException(("Cannot add deeplink from KClass [" + route + "]. DeepLink contains unknown argument [" + namedNavArgument.getName() + "]. Ensure deeplink arguments matches the destination's route from KClass").toString());
            }
            while (r0.hasNext()) {
            }
        }
        Map<KType, ? extends NavType<?>> map3 = this.typeMap;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeMap");
        } else {
            map2 = map3;
        }
        deepLink(NavDeepLinkDslBuilderKt.navDeepLink(route, basePath, map2, navDeepLink));
    }

    public final void deepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.deepLinks.add(navDeepLink);
    }

    @Deprecated(message = "Building NavDestinations using IDs with the Kotlin DSL has been deprecated in favor of using routes. When using routes there is no need for actions.")
    public final void action(int i, Function1<? super NavActionBuilder, Unit> actionBuilder) {
        Intrinsics.checkNotNullParameter(actionBuilder, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(i);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        actionBuilder.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_release());
    }

    protected D instantiateDestination() {
        return this.navigator.createDestination();
    }

    public D build() {
        D instantiateDestination = instantiateDestination();
        instantiateDestination.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            instantiateDestination.addArgument(entry.getKey(), entry.getValue());
        }
        for (NavDeepLink navDeepLink : this.deepLinks) {
            instantiateDestination.addDeepLink(navDeepLink);
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            instantiateDestination.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        String str = this.route;
        if (str != null) {
            instantiateDestination.setRoute(str);
        }
        int i = this.id;
        if (i != -1) {
            instantiateDestination.setId(i);
        }
        return instantiateDestination;
    }
}

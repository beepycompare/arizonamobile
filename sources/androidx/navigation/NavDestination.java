package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDestination;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
/* compiled from: NavDestination.android.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 h2\u00020\u0001:\u0003fghB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0017J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010D\u001a\u00020EH\u0016J\u000e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0003J\u000e\u0010F\u001a\u00020/2\u0006\u0010H\u001a\u00020\"J\u0012\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010:\u001a\u00020\u0003H\u0007J\u0012\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020EH\u0017J\u0014\u0010M\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0000H\u0007J \u0010P\u001a\u00020A2\u0006\u0010:\u001a\u00020\u00032\u000e\u0010)\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RH\u0007J\b\u0010S\u001a\u00020AH\u0017J\u0012\u0010T\u001a\u0004\u0018\u00010(2\b\b\u0001\u00105\u001a\u000204J\u001a\u0010U\u001a\u00020/2\b\b\u0001\u0010V\u001a\u0002042\b\b\u0001\u0010W\u001a\u000204J\u0018\u0010U\u001a\u00020/2\b\b\u0001\u0010V\u001a\u0002042\u0006\u0010X\u001a\u00020(J\u0010\u0010Y\u001a\u00020/2\b\b\u0001\u0010V\u001a\u000204J\u0016\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020+J\u000e\u0010]\u001a\u00020/2\u0006\u0010[\u001a\u00020\u0003J \u0010^\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`R2\u000e\u0010_\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RH\u0007J \u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u0002012\u000e\u0010a\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RJ\b\u0010b\u001a\u00020\u0003H\u0016J\u0013\u0010c\u001a\u00020A2\b\u0010d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010e\u001a\u000204H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u0005*\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b$\u0010%*\u0004\b#\u0010\u0017R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*8F¢\u0006\u0006\u001a\u0004\b,\u0010-R&\u00105\u001a\u0002042\b\b\u0001\u0010\r\u001a\u0002048G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R/\u0010:\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\u0005*\u0004\b;\u0010\u0017R\u0014\u0010>\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\n¨\u0006i"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigatorName", "", "<init>", "(Ljava/lang/String;)V", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "getNavigatorName", "()Ljava/lang/String;", "impl", "Landroidx/navigation/internal/NavDestinationImpl;", "value", "Landroidx/navigation/NavGraph;", "parent", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "<set-?>", "idName", "getIdName$delegate", "(Landroidx/navigation/NavDestination;)Ljava/lang/Object;", "getIdName", "setIdName", Constants.ScionAnalytics.PARAM_LABEL, "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "getDeepLinks$delegate", "getDeepLinks", "()Ljava/util/List;", "actions", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "Landroidx/navigation/NavArgument;", "getArguments", "()Ljava/util/Map;", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "", "id", "getId", "()I", "setId", "(I)V", "route", "getRoute$delegate", "getRoute", "setRoute", "displayName", "getDisplayName", "hasDeepLink", "", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "addDeepLink", "uriPattern", "navDeepLink", "matchRoute", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "navDeepLinkRequest", "buildDeepLinkIds", "", "previousDestination", "hasRoute", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "supportsActions", "getAction", "putAction", "actionId", "destId", "action", "removeAction", "addArgument", "argumentName", "argument", "removeArgument", "addInDefaultArgs", "args", "fillInLabel", "bundle", "toString", "equals", "other", "hashCode", "ClassType", "DeepLinkMatch", "Companion", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavDestination {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private final SparseArrayCompat<NavAction> actions;
    private final NavDestinationImpl impl;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;

    /* compiled from: NavDestination.android.kt */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    /* loaded from: classes3.dex */
    public @interface ClassType {
        Class<?> value();
    }

    @JvmStatic
    public static final String getDisplayName(NavContext navContext, int i) {
        return Companion.getDisplayName(navContext, i);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
        return Companion.getHierarchy(navDestination);
    }

    @JvmStatic
    public static final <T> boolean hasRoute(NavDestination navDestination, KClass<T> kClass) {
        return Companion.hasRoute(navDestination, kClass);
    }

    @JvmStatic
    protected static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return Companion.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return Companion.parseClassFromNameInternal(context, str, cls);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean supportsActions() {
        return true;
    }

    public NavDestination(String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.impl = new NavDestinationImpl(this);
        this.actions = new SparseArrayCompat<>(0, 1, null);
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    /* compiled from: NavDestination.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", "<init>", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = this.isExactDeepLink;
            if (!z || other.isExactDeepLink) {
                if (z || !other.isExactDeepLink) {
                    int i = this.matchingPathSegments - other.matchingPathSegments;
                    if (i > 0) {
                        return 1;
                    }
                    if (i < 0) {
                        return -1;
                    }
                    Bundle bundle = this.matchingArgs;
                    if (bundle == null || other.matchingArgs != null) {
                        if (bundle != null || other.matchingArgs == null) {
                            if (bundle != null) {
                                int m7660sizeimpl = SavedStateReader.m7660sizeimpl(SavedStateReader.m7580constructorimpl(bundle));
                                Bundle bundle2 = other.matchingArgs;
                                Intrinsics.checkNotNull(bundle2);
                                int m7660sizeimpl2 = m7660sizeimpl - SavedStateReader.m7660sizeimpl(SavedStateReader.m7580constructorimpl(bundle2));
                                if (m7660sizeimpl2 > 0) {
                                    return 1;
                                }
                                if (m7660sizeimpl2 < 0) {
                                    return -1;
                                }
                            }
                            boolean z2 = this.hasMatchingAction;
                            if (!z2 || other.hasMatchingAction) {
                                if (z2 || !other.hasMatchingAction) {
                                    return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
            return 1;
        }

        public final boolean hasMatchingArgs(Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || (bundle2 = this.matchingArgs) == null) {
                return false;
            }
            Set<String> keySet = bundle2.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "keySet(...)");
            for (String str : keySet) {
                Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
                Intrinsics.checkNotNull(str);
                if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, str)) {
                    return false;
                }
                NavArgument navArgument = this.destination.getArguments().get(str);
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                Object obj = type != null ? type.get(this.matchingArgs, str) : null;
                Object obj2 = type != null ? type.get(bundle, str) : null;
                if (type != null && !type.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    private final String getIdName() {
        return this.impl.getIdName$navigation_common_release();
    }

    private final void setIdName(String str) {
        this.impl.setIdName$navigation_common_release(str);
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    private final List<NavDeepLink> getDeepLinks() {
        return this.impl.getDeepLinks$navigation_common_release();
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this.impl.getArguments$navigation_common_release());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onInflate(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        setRoute(obtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        if (obtainAttributes.hasValue(androidx.navigation.common.R.styleable.Navigator_android_id)) {
            setId(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
            setIdName(Companion.getDisplayName(new NavContext(context), getId()));
        }
        this.label = obtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final int getId() {
        return this.impl.getId$navigation_common_release();
    }

    public final void setId(int i) {
        this.impl.setId$navigation_common_release(i);
    }

    public final String getRoute() {
        return this.impl.getRoute$navigation_common_release();
    }

    public final void setRoute(String str) {
        this.impl.setRoute$navigation_common_release(str);
    }

    public String getDisplayName() {
        String idName = getIdName();
        return idName == null ? String.valueOf(getId()) : idName;
    }

    public boolean hasDeepLink(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    public final void addDeepLink(String uriPattern) {
        Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.impl.addDeepLink$navigation_common_release(navDeepLink);
    }

    public final DeepLinkMatch matchRoute(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.matchRoute$navigation_common_release(route);
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return this.impl.matchDeepLink$navigation_common_release(navDeepLinkRequest);
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                navDestination2 = null;
            }
            return navDestination.buildDeepLinkIds(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    public final int[] buildDeepLinkIds(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this;
        while (true) {
            Intrinsics.checkNotNull(navGraph);
            NavGraph navGraph2 = navGraph.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph3 = navDestination.parent;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.findNode(navGraph.getId()) == navGraph) {
                    arrayDeque.addFirst(navGraph);
                    break;
                }
            }
            if (navGraph2 == null || navGraph2.getStartDestinationId() != navGraph.getId()) {
                arrayDeque.addFirst(navGraph);
            }
            if (Intrinsics.areEqual(navGraph2, navDestination)) {
                break;
            }
            navGraph = navGraph2;
            if (navGraph == null) {
                break;
            }
        }
        List<NavDestination> list = CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (NavDestination navDestination2 : list) {
            arrayList.add(Integer.valueOf(navDestination2.getId()));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public final boolean hasRoute(String route, Bundle bundle) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.hasRoute$navigation_common_release(route, bundle);
    }

    public final NavAction getAction(int i) {
        NavAction navAction = this.actions.getIsEmpty() ? null : this.actions.get(i);
        if (navAction == null) {
            NavGraph navGraph = this.parent;
            if (navGraph != null) {
                return navGraph.getAction(i);
            }
            return null;
        }
        return navAction;
    }

    public final void putAction(int i, int i2) {
        putAction(i, new NavAction(i2, null, null, 6, null));
    }

    public final void putAction(int i, NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
        this.actions.put(i, action);
    }

    public final void removeAction(int i) {
        this.actions.remove(i);
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.impl.addArgument$navigation_common_release(argumentName, argument);
    }

    public final void removeArgument(String argumentName) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        this.impl.removeArgument$navigation_common_release(argumentName);
    }

    public final Bundle addInDefaultArgs(Bundle bundle) {
        return this.impl.addInDefaultArgs$navigation_common_release(bundle);
    }

    public final String fillInLabel(Context context, Bundle bundle) {
        Map<String, Object> emptyMap;
        String valueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        if (bundle == null || (emptyMap = SavedStateReader.m7661toMapimpl(SavedStateReader.m7580constructorimpl(bundle))) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null || !emptyMap.containsKey(group)) {
                throw new IllegalArgumentException(("Could not find \"" + group + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"').toString());
            }
            matcher.appendReplacement(stringBuffer, "");
            NavArgument navArgument = getArguments().get(group);
            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
            if (Intrinsics.areEqual(type, NavType.ReferenceType)) {
                NavType<Integer> navType = NavType.ReferenceType;
                Intrinsics.checkNotNull(bundle);
                Integer num = navType.get(bundle, group);
                Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
                valueOf = context.getString(num.intValue());
            } else {
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(bundle);
                valueOf = String.valueOf(type.get(bundle, group));
            }
            Intrinsics.checkNotNull(valueOf);
            stringBuffer.append(valueOf);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        if (getIdName() == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(getId()));
        } else {
            sb.append(getIdName());
        }
        sb.append(")");
        String route = getRoute();
        if (route != null && !StringsKt.isBlank(route)) {
            sb.append(" route=");
            sb.append(getRoute());
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavDestination)) {
            NavDestination navDestination = (NavDestination) obj;
            boolean areEqual = Intrinsics.areEqual(getDeepLinks(), navDestination.getDeepLinks());
            if (this.actions.size() != navDestination.actions.size()) {
                z = false;
                break;
            }
            for (Number number : SequencesKt.asSequence(SparseArrayKt.keyIterator(this.actions))) {
                int intValue = number.intValue();
                if (!Intrinsics.areEqual(this.actions.get(intValue), navDestination.actions.get(intValue))) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (getArguments().size() == navDestination.getArguments().size()) {
                for (Map.Entry entry : MapsKt.asSequence(getArguments())) {
                    if (navDestination.getArguments().containsKey(entry.getKey())) {
                        if (!Intrinsics.areEqual(navDestination.getArguments().get(entry.getKey()), entry.getValue())) {
                        }
                    }
                }
                z2 = true;
                if (getId() != navDestination.getId() && Intrinsics.areEqual(getRoute(), navDestination.getRoute()) && areEqual && z && z2) {
                    return true;
                }
            }
            z2 = false;
            if (getId() != navDestination.getId()) {
            }
        }
        return false;
    }

    public int hashCode() {
        int id = getId() * 31;
        String route = getRoute();
        int hashCode = id + (route != null ? route.hashCode() : 0);
        for (NavDeepLink navDeepLink : getDeepLinks()) {
            int i = hashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int hashCode2 = (i + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int hashCode3 = (hashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            hashCode = hashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator valueIterator = SparseArrayKt.valueIterator(this.actions);
        while (valueIterator.hasNext()) {
            NavAction navAction = (NavAction) valueIterator.next();
            int destinationId = ((hashCode * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            hashCode = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null) {
                hashCode = (hashCode * 31) + SavedStateReader.m7583contentDeepHashCodeimpl(SavedStateReader.m7580constructorimpl(defaultArguments));
            }
        }
        for (String str : getArguments().keySet()) {
            int hashCode4 = ((hashCode * 31) + str.hashCode()) * 31;
            NavArgument navArgument = getArguments().get(str);
            hashCode = hashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return hashCode;
    }

    /* compiled from: NavDestination.android.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007H\u0005J:\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007J\u0019\u0010\u001c\u001a\u00020\u001d\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u0001*\u00020\u0017H\u0087\bJ$\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0001*\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001fH\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "<init>", "()V", "classes", "", "", "Ljava/lang/Class;", "parseClassFromName", "C", "context", "Landroid/content/Context;", "name", "expectedClassType", "parseClassFromNameInternal", "getDisplayName", "Landroidx/navigation/internal/NavContext;", "id", "", "createRoute", "route", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "hasRoute", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        private Companion() {
        }

        @JvmStatic
        protected final <C> Class<? extends C> parseClassFromName(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            String str = name.charAt(0) == '.' ? context.getPackageName() + name : name;
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            Intrinsics.checkNotNull(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        @JvmStatic
        public final String getDisplayName(NavContext context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            return context.getResourceName(i);
        }

        public final String createRoute(String str) {
            return str != null ? "android-app://androidx.navigation/" + str : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NavDestination _get_hierarchy_$lambda$1(NavDestination it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getParent();
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, new Function1() { // from class: androidx.navigation.NavDestination$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    NavDestination _get_hierarchy_$lambda$1;
                    _get_hierarchy_$lambda$1 = NavDestination.Companion._get_hierarchy_$lambda$1((NavDestination) obj);
                    return _get_hierarchy_$lambda$1;
                }
            });
        }

        @JvmStatic
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @JvmStatic
        public final <T> boolean hasRoute(NavDestination navDestination, KClass<T> route) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.checkNotNullParameter(route, "route");
            return RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)) == navDestination.getId();
        }
    }
}

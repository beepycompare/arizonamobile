package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.BundleKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: NavInflater.android.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J(\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J,\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J0\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/navigation/NavInflater;", "", "context", "Landroid/content/Context;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "<init>", "(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V", "inflate", "Landroidx/navigation/NavGraph;", "graphResId", "", "Landroidx/navigation/NavDestination;", "res", "Landroid/content/res/Resources;", "parser", "Landroid/content/res/XmlResourceParser;", "attrs", "Landroid/util/AttributeSet;", "inflateArgumentForDestination", "", "dest", "inflateArgumentForBundle", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "inflateArgument", "Landroidx/navigation/NavArgument;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/content/res/TypedArray;", "inflateDeepLink", "inflateAction", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavInflater {
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private final Context context;
    private final NavigatorProvider navigatorProvider;
    public static final Companion Companion = new Companion(null);
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.context = context;
        this.navigatorProvider = navigatorProvider;
    }

    public final NavGraph inflate(int i) {
        int next;
        Resources resources = this.context.getResources();
        XmlResourceParser xml = resources.getXml(i);
        Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        Intrinsics.checkNotNull(resources);
        Intrinsics.checkNotNull(asAttributeSet);
        NavDestination inflate = inflate(resources, xml, asAttributeSet, i);
        if (!(inflate instanceof NavGraph)) {
            throw new IllegalArgumentException(("Root element <" + name + "> did not inflate into a NavGraph").toString());
        }
        return (NavGraph) inflate;
    }

    private final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavigatorProvider navigatorProvider = this.navigatorProvider;
        String name = xmlResourceParser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        NavDestination createDestination = navigatorProvider.getNavigator(name).createDestination();
        createDestination.onInflate(this.context, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.areEqual(TAG_ARGUMENT, name2)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i);
                } else if (Intrinsics.areEqual(TAG_DEEP_LINK, name2)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if (Intrinsics.areEqual(TAG_ACTION, name2)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i);
                } else {
                    Resources resources2 = resources;
                    XmlResourceParser xmlResourceParser2 = xmlResourceParser;
                    AttributeSet attributeSet2 = attributeSet;
                    int i2 = i;
                    if (Intrinsics.areEqual(TAG_INCLUDE, name2) && (createDestination instanceof NavGraph)) {
                        TypedArray obtainAttributes = resources2.obtainAttributes(attributeSet2, R.styleable.NavInclude);
                        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
                        ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                        Unit unit = Unit.INSTANCE;
                        obtainAttributes.recycle();
                    } else if (createDestination instanceof NavGraph) {
                        ((NavGraph) createDestination).addDestination(inflate(resources2, xmlResourceParser2, attributeSet2, i2));
                    }
                    resources = resources2;
                    attributeSet = attributeSet2;
                    xmlResourceParser = xmlResourceParser2;
                    i = i2;
                }
            }
        }
        return createDestination;
    }

    private final void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    private final void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
        if (inflateArgument.isDefaultValuePresent()) {
            inflateArgument.putDefaultValue(string, bundle);
        }
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    private final NavArgument inflateArgument(TypedArray typedArray, Resources resources, int i) throws XmlPullParserException {
        int i2;
        NavArgument.Builder builder = new NavArgument.Builder();
        builder.setIsNullable(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        TypedValue typedValue2 = typedValue;
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object obj = null;
        NavType<?> fromArgType = string != null ? NavType.Companion.fromArgType(string, resources.getResourcePackageName(i)) : null;
        if (typedArray.getValue(androidx.navigation.common.R.styleable.NavArgument_android_defaultValue, typedValue2)) {
            if (fromArgType == NavType.ReferenceType) {
                if (typedValue2.resourceId != 0) {
                    i2 = Integer.valueOf(typedValue2.resourceId);
                } else if (typedValue2.type == 16 && typedValue2.data == 0) {
                    i2 = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue2.string) + "' for " + fromArgType.getName() + ". Must be a reference to a resource.");
                }
                obj = i2;
            } else if (typedValue2.resourceId != 0) {
                if (fromArgType == null) {
                    fromArgType = NavType.ReferenceType;
                    obj = Integer.valueOf(typedValue2.resourceId);
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue2.string) + "' for " + fromArgType.getName() + ". You must use a \"" + NavType.ReferenceType.getName() + "\" type to reference other resources.");
                }
            } else if (fromArgType == NavType.StringType) {
                obj = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_android_defaultValue);
            } else {
                int i3 = typedValue2.type;
                if (i3 == 3) {
                    String obj2 = typedValue2.string.toString();
                    if (fromArgType == null) {
                        fromArgType = NavType.Companion.inferFromValue(obj2);
                    }
                    obj = fromArgType.parseValue(obj2);
                } else if (i3 == 4) {
                    fromArgType = Companion.checkNavType$navigation_runtime_release(typedValue2, fromArgType, NavType.FloatType, string, TypedValues.Custom.S_FLOAT);
                    obj = Float.valueOf(typedValue2.getFloat());
                } else if (i3 == 5) {
                    fromArgType = Companion.checkNavType$navigation_runtime_release(typedValue2, fromArgType, NavType.IntType, string, TypedValues.Custom.S_DIMENSION);
                    obj = Integer.valueOf((int) typedValue2.getDimension(resources.getDisplayMetrics()));
                } else if (i3 == 18) {
                    fromArgType = Companion.checkNavType$navigation_runtime_release(typedValue2, fromArgType, NavType.BoolType, string, TypedValues.Custom.S_BOOLEAN);
                    obj = Boolean.valueOf(typedValue2.data != 0);
                } else if (typedValue2.type >= 16 && typedValue2.type <= 31) {
                    if (fromArgType == NavType.FloatType) {
                        fromArgType = Companion.checkNavType$navigation_runtime_release(typedValue2, fromArgType, NavType.FloatType, string, TypedValues.Custom.S_FLOAT);
                        obj = Float.valueOf(typedValue2.data);
                    } else {
                        fromArgType = Companion.checkNavType$navigation_runtime_release(typedValue2, fromArgType, NavType.IntType, string, TypedValues.Custom.S_INT);
                        obj = Integer.valueOf(typedValue2.data);
                    }
                } else {
                    throw new XmlPullParserException("unsupported argument type " + typedValue2.type);
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    private final void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        String str;
        String str2;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        String str3 = string;
        if ((str3 == null || str3.length() == 0) && (((str = string2) == null || str.length() == 0) && ((str2 = string3) == null || str2.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            String packageName = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            builder.setUriPattern(StringsKt.replace$default(string, APPLICATION_ID_PLACEHOLDER, packageName, false, 4, (Object) null));
        }
        String str4 = string2;
        if (str4 != null && str4.length() != 0) {
            String packageName2 = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
            builder.setAction(StringsKt.replace$default(string2, APPLICATION_ID_PLACEHOLDER, packageName2, false, 4, (Object) null));
        }
        if (string3 != null) {
            String packageName3 = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
            builder.setMimeType(StringsKt.replace$default(string3, APPLICATION_ID_PLACEHOLDER, packageName3, false, 4, (Object) null));
        }
        navDestination.addDeepLink(builder.build());
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    private final void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        Pair[] pairArr;
        int depth;
        Context context = this.context;
        int[] NavAction = androidx.navigation.common.R.styleable.NavAction;
        Intrinsics.checkNotNullExpressionValue(NavAction, "NavAction");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NavAction, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0), null, null, 6, null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        builder.setRestoreState(obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_restoreState, false));
        builder.setPopUpTo(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToSaveState, false));
        builder.setEnterAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(emptyMap.size());
            for (Map.Entry entry : emptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7666constructorimpl(bundleOf);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && Intrinsics.areEqual(TAG_ARGUMENT, xmlResourceParser.getName())) {
                inflateArgumentForBundle(resources, bundleOf, attributeSet, i);
            }
        }
        if (!SavedStateReader.m7658isEmptyimpl(SavedStateReader.m7580constructorimpl(bundleOf))) {
            navAction.setDefaultArguments(bundleOf);
        }
        navDestination.putAction(resourceId, navAction);
        obtainStyledAttributes.recycle();
    }

    /* compiled from: NavInflater.android.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavInflater$Companion;", "", "<init>", "()V", "TAG_ARGUMENT", "", "TAG_DEEP_LINK", "TAG_ACTION", "TAG_INCLUDE", "APPLICATION_ID_PLACEHOLDER", "sTmpValue", "Ljava/lang/ThreadLocal;", "Landroid/util/TypedValue;", "checkNavType", "Landroidx/navigation/NavType;", "value", "navType", "expectedNavType", "argType", "foundType", "checkNavType$navigation_runtime_release", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavType<?> checkNavType$navigation_runtime_release(TypedValue value, NavType<?> navType, NavType<?> expectedNavType, String str, String foundType) throws XmlPullParserException {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(expectedNavType, "expectedNavType");
            Intrinsics.checkNotNullParameter(foundType, "foundType");
            if (navType == null || navType == expectedNavType) {
                return navType == null ? expectedNavType : navType;
            }
            throw new XmlPullParserException("Type is " + str + " but found " + foundType + ": " + value.data);
        }
    }
}

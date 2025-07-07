package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.ObjectFloatMapKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.internal.NavComposeUtils_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0018\u001a\u0098\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001c\u001a¿\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\"\u001a»\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020#2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010$\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010'\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010(\u001aó\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010/\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010\u001b*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¨\u00061²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "startDestination", "", "modifier", "Landroidx/compose/ui/Modifier;", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/jvm/JvmSuppressWildcards;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "(Landroidx/navigation/NavHostController;Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "", "(Landroidx/navigation/NavHostController;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "graph", "Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "navigation-compose_release", "currentBackStack", "", "progress", "", "inPredictiveBack", "", "allVisibleEntries", "visibleEntries"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$1(NavHostController navHostController, String str, Modifier modifier, String str2, Function1 function1, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$13(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$19(NavHostController navHostController, KClass kClass, Modifier modifier, Alignment alignment, KClass kClass2, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, (KClass<?>) kClass, modifier, alignment, (KClass<?>) kClass2, (Map<KType, NavType<?>>) map, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function1, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function12, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function15, (Function1<? super NavGraphBuilder, Unit>) function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$25(NavHostController navHostController, Object obj, Modifier modifier, Alignment alignment, KClass kClass, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, obj, modifier, alignment, kClass, map, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$26(NavHostController navHostController, NavGraph navGraph, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$31(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$37(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$7(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$79(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$80(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final String str, Modifier modifier, String str2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        String str3;
        boolean z;
        Object rememberedValue;
        final Modifier modifier2;
        final String str4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(2,4,1,3)94@3842L126,92@3802L190:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = str2;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj;
                    str3 = i4 != 0 ? null : obj2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(141827520, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:91)");
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142694498, "CC(remember):NavHost.kt#9igjgp");
                    z = ((i3 & 7168) == 2048) | ((i3 & 112) == 32) | ((57344 & i3) == 16384);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                        function1.invoke(navGraphBuilder);
                        rememberedValue = navGraphBuilder.build();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i6 = i3 & 910;
                    Modifier modifier3 = companion;
                    NavHost(navHostController, (NavGraph) rememberedValue, modifier3, null, null, null, null, null, null, startRestartGroup, i6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    str4 = str3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    str4 = obj2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Unit NavHost$lambda$1;
                            NavHost$lambda$1 = NavHostKt.NavHost$lambda$1(NavHostController.this, str, modifier2, str4, function1, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            return NavHost$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            obj2 = str2;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142694498, "CC(remember):NavHost.kt#9igjgp");
            z = ((i3 & 7168) == 2048) | ((i3 & 112) == 32) | ((57344 & i3) == 16384);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
            function1.invoke(navGraphBuilder2);
            rememberedValue = navGraphBuilder2.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i62 = i3 & 910;
            Modifier modifier32 = companion;
            NavHost(navHostController, (NavGraph) rememberedValue, modifier32, null, null, null, null, null, null, startRestartGroup, i62, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier32;
            str4 = str3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj2 = str2;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142694498, "CC(remember):NavHost.kt#9igjgp");
        z = ((i3 & 7168) == 2048) | ((i3 & 112) == 32) | ((57344 & i3) == 16384);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        NavGraphBuilder navGraphBuilder22 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
        function1.invoke(navGraphBuilder22);
        rememberedValue = navGraphBuilder22.build();
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i622 = i3 & 910;
        Modifier modifier322 = companion;
        NavHost(navHostController, (NavGraph) rememberedValue, modifier322, null, null, null, null, null, null, startRestartGroup, i622, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier322;
        str4 = str3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$3$lambda$2(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$5$lambda$4(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, final Function1 function15, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        Function1 function16;
        Function1 function17;
        int i8;
        Object obj5;
        Alignment alignment2;
        Function1 function18;
        Function1 function19;
        String str3;
        Object obj6;
        boolean z;
        Object rememberedValue;
        final Function1 function110;
        Composer composer2;
        final Function1 function111;
        final Function1 function112;
        final Alignment alignment3;
        final Function1 function113;
        final String str4;
        final Modifier modifier2;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(410432995);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,9,4,1,8,2,3,6,7)146@6067L126,144@6027L320:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = alignment;
                i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj2 = str2;
                    i3 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj3 = function1;
                    } else {
                        obj3 = function1;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
                        }
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i3 |= 1572864;
                        obj4 = function12;
                    } else {
                        obj4 = function12;
                        if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(obj4) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changedInstance(function13)) {
                            i10 = 8388608;
                            i3 |= i10;
                        }
                        i10 = 4194304;
                        i3 |= i10;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & 256) == 0 && startRestartGroup.changedInstance(function14)) {
                            i9 = 67108864;
                            i3 |= i9;
                        }
                        i9 = 33554432;
                        i3 |= i9;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function15) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    }
                    if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "132@5532L50,135@5679L51");
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                obj = Alignment.Companion.getTopStart();
                            }
                            if (i5 != 0) {
                                obj2 = null;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -710868907, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj7) {
                                            EnterTransition NavHost$lambda$3$lambda$2;
                                            NavHost$lambda$3$lambda$2 = NavHostKt.NavHost$lambda$3$lambda$2((AnimatedContentTransitionScope) obj7);
                                            return NavHost$lambda$3$lambda$2;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                obj3 = (Function1) rememberedValue2;
                            }
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -710864202, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj7) {
                                            ExitTransition NavHost$lambda$5$lambda$4;
                                            NavHost$lambda$5$lambda$4 = NavHostKt.NavHost$lambda$5$lambda$4((AnimatedContentTransitionScope) obj7);
                                            return NavHost$lambda$5$lambda$4;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                obj4 = (Function1) rememberedValue3;
                            }
                            if ((i2 & 128) == 0) {
                                i3 &= -29360129;
                                function16 = obj3;
                            } else {
                                function16 = function13;
                            }
                            if ((i2 & 256) == 0) {
                                function17 = function16;
                                i8 = i3 & (-234881025);
                                obj5 = companion;
                                alignment2 = obj;
                                function18 = obj4;
                                function19 = function18;
                                str3 = obj2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    obj6 = obj5;
                                } else {
                                    obj6 = obj5;
                                    ComposerKt.traceEventStart(410432995, i8, -1, "androidx.navigation.compose.NavHost (NavHost.kt:143)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -710851711, "CC(remember):NavHost.kt#9igjgp");
                                z = ((57344 & i8) != 16384) | ((i8 & 112) != 32) | ((1879048192 & i8) != 536870912);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                                    NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                                    function15.invoke(navGraphBuilder);
                                    rememberedValue = navGraphBuilder.build();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i12 = i8 & 8078;
                                int i13 = i8 >> 3;
                                int i14 = i12 | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 29360128);
                                Modifier modifier3 = obj6;
                                String str5 = str3;
                                NavHost(navHostController, (NavGraph) rememberedValue, modifier3, alignment2, obj3, function18, function17, function19, null, startRestartGroup, i14, 256);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function110 = function17;
                                composer2 = startRestartGroup;
                                function111 = obj3;
                                function112 = function19;
                                alignment3 = alignment2;
                                function113 = function18;
                                str4 = str5;
                                modifier2 = modifier3;
                            } else {
                                function17 = function16;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            function17 = function13;
                        }
                        i8 = i3;
                        obj5 = companion;
                        alignment2 = obj;
                        function18 = obj4;
                        str3 = obj2;
                        function19 = function14;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -710851711, "CC(remember):NavHost.kt#9igjgp");
                        z = ((57344 & i8) != 16384) | ((i8 & 112) != 32) | ((1879048192 & i8) != 536870912);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                        function15.invoke(navGraphBuilder2);
                        rememberedValue = navGraphBuilder2.build();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i122 = i8 & 8078;
                        int i132 = i8 >> 3;
                        int i142 = i122 | (57344 & i132) | (458752 & i132) | (3670016 & i132) | (i132 & 29360128);
                        Modifier modifier32 = obj6;
                        String str52 = str3;
                        NavHost(navHostController, (NavGraph) rememberedValue, modifier32, alignment2, obj3, function18, function17, function19, null, startRestartGroup, i142, 256);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function110 = function17;
                        composer2 = startRestartGroup;
                        function111 = obj3;
                        function112 = function19;
                        alignment3 = alignment2;
                        function113 = function18;
                        str4 = str52;
                        modifier2 = modifier32;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function110 = function13;
                        function111 = obj3;
                        modifier2 = companion;
                        alignment3 = obj;
                        composer2 = startRestartGroup;
                        function113 = obj4;
                        str4 = obj2;
                        function112 = function14;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj7, Object obj8) {
                                Unit NavHost$lambda$7;
                                NavHost$lambda$7 = NavHostKt.NavHost$lambda$7(NavHostController.this, str, modifier2, alignment3, str4, function111, function113, function110, function112, function15, i, i2, (Composer) obj7, ((Integer) obj8).intValue());
                                return NavHost$lambda$7;
                            }
                        });
                        return;
                    }
                    return;
                }
                obj2 = str2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "132@5532L50,135@5679L51");
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((i2 & 256) == 0) {
                }
            }
            obj = alignment;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj2 = str2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "132@5532L50,135@5679L51");
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((i2 & 256) == 0) {
            }
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj = alignment;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj2 = str2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "132@5532L50,135@5679L51");
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$9$lambda$8(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$11$lambda$10(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        Object obj5;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function18;
        Object obj6;
        Object obj7;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function19;
        String str3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function110;
        int i13;
        Object obj8;
        boolean z;
        Object rememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function111;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function112;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function114;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function115;
        final String str4;
        final Alignment alignment2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1840250294);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,10,4,1,8,2,3,6,7,9)214@8718L126,212@8678L343:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i16 = i3 & 4;
        if (i16 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = alignment;
                i4 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = str2;
                    i4 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj4 = function1;
                    } else {
                        obj4 = function1;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj4) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function12) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            obj5 = function13;
                            if (startRestartGroup.changedInstance(obj5)) {
                                i15 = 8388608;
                                i4 |= i15;
                            }
                        } else {
                            obj5 = function13;
                        }
                        i15 = 4194304;
                        i4 |= i15;
                    } else {
                        obj5 = function13;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changedInstance(function14)) {
                            i14 = 67108864;
                            i4 |= i14;
                        }
                        i14 = 33554432;
                        i4 |= i14;
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i10 = i9;
                        i4 |= startRestartGroup.changedInstance(function15) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i2 | (startRestartGroup.changedInstance(function16) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        i12 = i4;
                        if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "189@7898L58,195@8099L59");
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i16 != 0 ? Modifier.Companion : obj;
                                Alignment topStart = i5 != 0 ? Alignment.Companion.getTopStart() : obj2;
                                if (i6 != 0) {
                                    obj3 = null;
                                }
                                if (i7 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045981872, "CC(remember):NavHost.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj9) {
                                                EnterTransition NavHost$lambda$9$lambda$8;
                                                NavHost$lambda$9$lambda$8 = NavHostKt.NavHost$lambda$9$lambda$8((AnimatedContentTransitionScope) obj9);
                                                return NavHost$lambda$9$lambda$8;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    obj4 = (Function1) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045975439, "CC(remember):NavHost.kt#9igjgp");
                                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda15
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj9) {
                                                ExitTransition NavHost$lambda$11$lambda$10;
                                                NavHost$lambda$11$lambda$10 = NavHostKt.NavHost$lambda$11$lambda$10((AnimatedContentTransitionScope) obj9);
                                                return NavHost$lambda$11$lambda$10;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    function17 = (Function1) rememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                } else {
                                    function17 = function12;
                                }
                                if ((i3 & 128) != 0) {
                                    i12 &= -29360129;
                                    obj5 = obj4;
                                }
                                if ((i3 & 256) != 0) {
                                    i12 &= -234881025;
                                    function18 = function17;
                                } else {
                                    function18 = function14;
                                }
                                if (i10 != 0) {
                                    function110 = null;
                                    Object obj9 = topStart;
                                    obj6 = obj4;
                                    obj7 = obj9;
                                    String str5 = obj3;
                                    function19 = obj5;
                                    str3 = str5;
                                } else {
                                    Object obj10 = topStart;
                                    obj6 = obj4;
                                    obj7 = obj10;
                                    String str6 = obj3;
                                    function19 = obj5;
                                    str3 = str6;
                                    function110 = function15;
                                }
                                i13 = i12;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                int i17 = (i3 & 128) != 0 ? i12 & (-29360129) : i12;
                                if ((i3 & 256) != 0) {
                                    i17 &= -234881025;
                                }
                                Object obj11 = obj3;
                                function19 = obj5;
                                str3 = obj11;
                                function18 = function14;
                                i13 = i17;
                                obj6 = obj4;
                                companion = obj;
                                obj7 = obj2;
                                function17 = function12;
                                function110 = function15;
                            }
                            startRestartGroup.endDefaults();
                            Modifier modifier3 = companion;
                            if (ComposerKt.isTraceInProgress()) {
                                obj8 = obj7;
                                ComposerKt.traceEventStart(1840250294, i13, i11, "androidx.navigation.compose.NavHost (NavHost.kt:211)");
                            } else {
                                obj8 = obj7;
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
                            z = ((57344 & i13) == 16384) | ((i13 & 112) == 32) | ((i11 & 14) == 4);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                                function16.invoke(navGraphBuilder);
                                rememberedValue = navGraphBuilder.build();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i18 = i13 >> 3;
                            Alignment alignment3 = obj8;
                            String str7 = str3;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function116 = obj6;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117 = function17;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118 = function18;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function119 = function110;
                            NavHost(navHostController, (NavGraph) rememberedValue, modifier3, alignment3, function116, function117, function19, function118, function119, startRestartGroup, (i13 & 8078) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function111 = function119;
                            composer2 = startRestartGroup;
                            function112 = function19;
                            function113 = function118;
                            function114 = function116;
                            function115 = function117;
                            str4 = str7;
                            alignment2 = alignment3;
                            modifier2 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function112 = obj5;
                            str4 = obj3;
                            composer2 = startRestartGroup;
                            alignment2 = obj2;
                            function113 = function14;
                            function111 = function15;
                            function114 = obj4;
                            modifier2 = obj;
                            function115 = function12;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj12, Object obj13) {
                                    Unit NavHost$lambda$13;
                                    NavHost$lambda$13 = NavHostKt.NavHost$lambda$13(NavHostController.this, str, modifier2, alignment2, str4, function114, function115, function112, function113, function111, function16, i, i2, i3, (Composer) obj12, ((Integer) obj13).intValue());
                                    return NavHost$lambda$13;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i10 = i9;
                    if ((i3 & 1024) != 0) {
                    }
                    i12 = i4;
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "189@7898L58,195@8099L59");
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    i13 = i12;
                    startRestartGroup.endDefaults();
                    Modifier modifier32 = companion;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
                    z = ((57344 & i13) == 16384) | ((i13 & 112) == 32) | ((i11 & 14) == 4);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                    function16.invoke(navGraphBuilder2);
                    rememberedValue = navGraphBuilder2.build();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i182 = i13 >> 3;
                    Alignment alignment32 = obj8;
                    String str72 = str3;
                    Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1162 = obj6;
                    Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172 = function17;
                    Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1182 = function18;
                    Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1192 = function110;
                    NavHost(navHostController, (NavGraph) rememberedValue, modifier32, alignment32, function1162, function1172, function19, function1182, function1192, startRestartGroup, (i13 & 8078) | (57344 & i182) | (458752 & i182) | (3670016 & i182) | (29360128 & i182) | (i182 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function111 = function1192;
                    composer2 = startRestartGroup;
                    function112 = function19;
                    function113 = function1182;
                    function114 = function1162;
                    function115 = function1172;
                    str4 = str72;
                    alignment2 = alignment32;
                    modifier2 = modifier32;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = str2;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i3 & 1024) != 0) {
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "189@7898L58,195@8099L59");
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if (i10 != 0) {
                }
                i13 = i12;
                startRestartGroup.endDefaults();
                Modifier modifier322 = companion;
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
                z = ((57344 & i13) == 16384) | ((i13 & 112) == 32) | ((i11 & 14) == 4);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                NavGraphBuilder navGraphBuilder22 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
                function16.invoke(navGraphBuilder22);
                rememberedValue = navGraphBuilder22.build();
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i1822 = i13 >> 3;
                Alignment alignment322 = obj8;
                String str722 = str3;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function11622 = obj6;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11722 = function17;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11822 = function18;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function11922 = function110;
                NavHost(navHostController, (NavGraph) rememberedValue, modifier322, alignment322, function11622, function11722, function19, function11822, function11922, startRestartGroup, (i13 & 8078) | (57344 & i1822) | (458752 & i1822) | (3670016 & i1822) | (29360128 & i1822) | (i1822 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function111 = function11922;
                composer2 = startRestartGroup;
                function112 = function19;
                function113 = function11822;
                function114 = function11622;
                function115 = function11722;
                str4 = str722;
                alignment2 = alignment322;
                modifier2 = modifier322;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = alignment;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = str2;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i3 & 1024) != 0) {
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "189@7898L58,195@8099L59");
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if (i10 != 0) {
            }
            i13 = i12;
            startRestartGroup.endDefaults();
            Modifier modifier3222 = companion;
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
            z = ((57344 & i13) == 16384) | ((i13 & 112) == 32) | ((i11 & 14) == 4);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            NavGraphBuilder navGraphBuilder222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
            function16.invoke(navGraphBuilder222);
            rememberedValue = navGraphBuilder222.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i18222 = i13 >> 3;
            Alignment alignment3222 = obj8;
            String str7222 = str3;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function116222 = obj6;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117222 = function17;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118222 = function18;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function119222 = function110;
            NavHost(navHostController, (NavGraph) rememberedValue, modifier3222, alignment3222, function116222, function117222, function19, function118222, function119222, startRestartGroup, (i13 & 8078) | (57344 & i18222) | (458752 & i18222) | (3670016 & i18222) | (29360128 & i18222) | (i18222 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function111 = function119222;
            composer2 = startRestartGroup;
            function112 = function19;
            function113 = function118222;
            function114 = function116222;
            function115 = function117222;
            str4 = str7222;
            alignment2 = alignment3222;
            modifier2 = modifier3222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        obj2 = alignment;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = str2;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i3 & 1024) != 0) {
        }
        i12 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "189@7898L58,195@8099L59");
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if (i10 != 0) {
        }
        i13 = i12;
        startRestartGroup.endDefaults();
        Modifier modifier32222 = companion;
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
        z = ((57344 & i13) == 16384) | ((i13 & 112) == 32) | ((i11 & 14) == 4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        NavGraphBuilder navGraphBuilder2222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str3);
        function16.invoke(navGraphBuilder2222);
        rememberedValue = navGraphBuilder2222.build();
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i182222 = i13 >> 3;
        Alignment alignment32222 = obj8;
        String str72222 = str3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1162222 = obj6;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172222 = function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1182222 = function18;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1192222 = function110;
        NavHost(navHostController, (NavGraph) rememberedValue, modifier32222, alignment32222, function1162222, function1172222, function19, function1182222, function1192222, startRestartGroup, (i13 & 8078) | (57344 & i182222) | (458752 & i182222) | (3670016 & i182222) | (29360128 & i182222) | (i182222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function111 = function1192222;
        composer2 = startRestartGroup;
        function112 = function19;
        function113 = function1182222;
        function114 = function1162222;
        function115 = function1172222;
        str4 = str72222;
        alignment2 = alignment32222;
        modifier2 = modifier32222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$15$lambda$14(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$17$lambda$16(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final KClass<?> kClass, Modifier modifier, Alignment alignment, KClass<?> kClass2, Map<KType, NavType<?>> map, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        Object obj5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        int i14;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function19;
        KClass<?> kClass3;
        Object obj6;
        Map<KType, NavType<?>> map2;
        Object obj7;
        int i15;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function110;
        Object obj8;
        boolean changed;
        Object rememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function111;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function112;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function114;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final KClass<?> kClass4;
        final Map<KType, NavType<?>> map3;
        final Alignment alignment2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(750467758);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)286@11665L135,284@11625L352:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(kClass) ? 32 : 16;
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = alignment;
                i4 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = kClass2;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj4 = map;
                    } else {
                        obj4 = map;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj4) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        obj5 = function1;
                    } else {
                        obj5 = function1;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj5) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changedInstance(function13)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changedInstance(function14)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i16;
                        }
                        i16 = 268435456;
                        i4 |= i16;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (startRestartGroup.changedInstance(function15) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= startRestartGroup.changedInstance(function16) ? 32 : 16;
                    }
                    i13 = i12;
                    int i19 = i4;
                    if ((i4 & 306783379) == 306783378 || (i13 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "261@10845L58,267@11046L59");
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i18 == 0 ? Modifier.Companion : obj;
                            Alignment topStart = i5 == 0 ? Alignment.Companion.getTopStart() : obj2;
                            if (i6 != 0) {
                                obj3 = null;
                            }
                            if (i7 != 0) {
                                obj4 = MapsKt.emptyMap();
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354976248, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda19
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj9) {
                                            EnterTransition NavHost$lambda$15$lambda$14;
                                            NavHost$lambda$15$lambda$14 = NavHostKt.NavHost$lambda$15$lambda$14((AnimatedContentTransitionScope) obj9);
                                            return NavHost$lambda$15$lambda$14;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                obj5 = (Function1) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            }
                            if (i9 == 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354969815, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda20
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj9) {
                                            ExitTransition NavHost$lambda$17$lambda$16;
                                            NavHost$lambda$17$lambda$16 = NavHostKt.NavHost$lambda$17$lambda$16((AnimatedContentTransitionScope) obj9);
                                            return NavHost$lambda$17$lambda$16;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                function17 = (Function1) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            } else {
                                function17 = function12;
                            }
                            if ((i3 & 256) == 0) {
                                i14 = i19 & (-234881025);
                                function18 = obj5;
                            } else {
                                function18 = function13;
                                i14 = i19;
                            }
                            if ((i3 & 512) == 0) {
                                i14 = (-1879048193) & i14;
                                function19 = function17;
                            } else {
                                function19 = function14;
                            }
                            Map<KType, NavType<?>> map4 = obj4;
                            kClass3 = obj3;
                            obj6 = topStart;
                            map2 = map4;
                            obj7 = companion;
                            i15 = i14;
                            if (i11 != 0) {
                                function110 = null;
                                startRestartGroup.endDefaults();
                                Alignment alignment3 = obj6;
                                if (ComposerKt.isTraceInProgress()) {
                                    obj8 = obj5;
                                    ComposerKt.traceEventStart(750467758, i15, i13, "androidx.navigation.compose.NavHost (NavHost.kt:283)");
                                } else {
                                    obj8 = obj5;
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                                changed = startRestartGroup.changed(kClass3) | startRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass3, map2);
                                    function16.invoke(navGraphBuilder);
                                    rememberedValue = navGraphBuilder.build();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i20 = i15 & 8078;
                                int i21 = i15 >> 6;
                                int i22 = ((i13 << 24) & 234881024) | (i21 & 29360128) | i20 | (57344 & i21) | (458752 & i21) | (3670016 & i21);
                                Map<KType, NavType<?>> map5 = map2;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116 = function17;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117 = function19;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function118 = function110;
                                Modifier modifier3 = obj7;
                                KClass<?> kClass5 = kClass3;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119 = function18;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120 = obj8;
                                NavHost(navHostController, (NavGraph) rememberedValue, modifier3, alignment3, function120, function116, function119, function117, function118, startRestartGroup, i22, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function111 = function117;
                                function112 = function118;
                                composer2 = startRestartGroup;
                                function113 = function120;
                                function114 = function116;
                                function115 = function119;
                                kClass4 = kClass5;
                                map3 = map5;
                                alignment2 = alignment3;
                                modifier2 = modifier3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            i15 = (i3 & 256) != 0 ? i19 & (-234881025) : i19;
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                            }
                            function17 = function12;
                            function18 = function13;
                            map2 = obj4;
                            obj7 = obj;
                            function19 = function14;
                            kClass3 = obj3;
                            obj6 = obj2;
                        }
                        function110 = function15;
                        startRestartGroup.endDefaults();
                        Alignment alignment32 = obj6;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                        changed = startRestartGroup.changed(kClass3) | startRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass3, map2);
                        function16.invoke(navGraphBuilder2);
                        rememberedValue = navGraphBuilder2.build();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i202 = i15 & 8078;
                        int i212 = i15 >> 6;
                        int i222 = ((i13 << 24) & 234881024) | (i212 & 29360128) | i202 | (57344 & i212) | (458752 & i212) | (3670016 & i212);
                        Map<KType, NavType<?>> map52 = map2;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1162 = function17;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172 = function19;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1182 = function110;
                        Modifier modifier32 = obj7;
                        KClass<?> kClass52 = kClass3;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1192 = function18;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1202 = obj8;
                        NavHost(navHostController, (NavGraph) rememberedValue, modifier32, alignment32, function1202, function1162, function1192, function1172, function1182, startRestartGroup, i222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function111 = function1172;
                        function112 = function1182;
                        composer2 = startRestartGroup;
                        function113 = function1202;
                        function114 = function1162;
                        function115 = function1192;
                        kClass4 = kClass52;
                        map3 = map52;
                        alignment2 = alignment32;
                        modifier2 = modifier32;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function111 = function14;
                        kClass4 = obj3;
                        function113 = obj5;
                        modifier2 = obj;
                        composer2 = startRestartGroup;
                        function114 = function12;
                        function115 = function13;
                        map3 = obj4;
                        alignment2 = obj2;
                        function112 = function15;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj9, Object obj10) {
                                Unit NavHost$lambda$19;
                                NavHost$lambda$19 = NavHostKt.NavHost$lambda$19(NavHostController.this, kClass, modifier2, alignment2, kClass4, map3, function113, function114, function115, function111, function112, function16, i, i2, i3, (Composer) obj9, ((Integer) obj10).intValue());
                                return NavHost$lambda$19;
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = kClass2;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i13 = i12;
                int i192 = i4;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "261@10845L58,267@11046L59");
                if ((i & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                Map<KType, NavType<?>> map42 = obj4;
                kClass3 = obj3;
                obj6 = topStart;
                map2 = map42;
                obj7 = companion;
                i15 = i14;
                if (i11 != 0) {
                }
                function110 = function15;
                startRestartGroup.endDefaults();
                Alignment alignment322 = obj6;
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                changed = startRestartGroup.changed(kClass3) | startRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                NavGraphBuilder navGraphBuilder22 = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass3, map2);
                function16.invoke(navGraphBuilder22);
                rememberedValue = navGraphBuilder22.build();
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i2022 = i15 & 8078;
                int i2122 = i15 >> 6;
                int i2222 = ((i13 << 24) & 234881024) | (i2122 & 29360128) | i2022 | (57344 & i2122) | (458752 & i2122) | (3670016 & i2122);
                Map<KType, NavType<?>> map522 = map2;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11622 = function17;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11722 = function19;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function11822 = function110;
                Modifier modifier322 = obj7;
                KClass<?> kClass522 = kClass3;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function11922 = function18;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function12022 = obj8;
                NavHost(navHostController, (NavGraph) rememberedValue, modifier322, alignment322, function12022, function11622, function11922, function11722, function11822, startRestartGroup, i2222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function111 = function11722;
                function112 = function11822;
                composer2 = startRestartGroup;
                function113 = function12022;
                function114 = function11622;
                function115 = function11922;
                kClass4 = kClass522;
                map3 = map522;
                alignment2 = alignment322;
                modifier2 = modifier322;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = alignment;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = kClass2;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i13 = i12;
            int i1922 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "261@10845L58,267@11046L59");
            if ((i & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            Map<KType, NavType<?>> map422 = obj4;
            kClass3 = obj3;
            obj6 = topStart;
            map2 = map422;
            obj7 = companion;
            i15 = i14;
            if (i11 != 0) {
            }
            function110 = function15;
            startRestartGroup.endDefaults();
            Alignment alignment3222 = obj6;
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
            changed = startRestartGroup.changed(kClass3) | startRestartGroup.changed(kClass) | ((i13 & 112) == 32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            NavGraphBuilder navGraphBuilder222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass3, map2);
            function16.invoke(navGraphBuilder222);
            rememberedValue = navGraphBuilder222.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i20222 = i15 & 8078;
            int i21222 = i15 >> 6;
            int i22222 = ((i13 << 24) & 234881024) | (i21222 & 29360128) | i20222 | (57344 & i21222) | (458752 & i21222) | (3670016 & i21222);
            Map<KType, NavType<?>> map5222 = map2;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116222 = function17;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117222 = function19;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function118222 = function110;
            Modifier modifier3222 = obj7;
            KClass<?> kClass5222 = kClass3;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119222 = function18;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120222 = obj8;
            NavHost(navHostController, (NavGraph) rememberedValue, modifier3222, alignment3222, function120222, function116222, function119222, function117222, function118222, startRestartGroup, i22222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function111 = function117222;
            function112 = function118222;
            composer2 = startRestartGroup;
            function113 = function120222;
            function114 = function116222;
            function115 = function119222;
            kClass4 = kClass5222;
            map3 = map5222;
            alignment2 = alignment3222;
            modifier2 = modifier3222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        obj2 = alignment;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = kClass2;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i13 = i12;
        int i19222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "261@10845L58,267@11046L59");
        if ((i & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        Map<KType, NavType<?>> map4222 = obj4;
        kClass3 = obj3;
        obj6 = topStart;
        map2 = map4222;
        obj7 = companion;
        i15 = i14;
        if (i11 != 0) {
        }
        function110 = function15;
        startRestartGroup.endDefaults();
        Alignment alignment32222 = obj6;
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
        changed = startRestartGroup.changed(kClass3) | startRestartGroup.changed(kClass) | ((i13 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        NavGraphBuilder navGraphBuilder2222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass3, map2);
        function16.invoke(navGraphBuilder2222);
        rememberedValue = navGraphBuilder2222.build();
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i202222 = i15 & 8078;
        int i212222 = i15 >> 6;
        int i222222 = ((i13 << 24) & 234881024) | (i212222 & 29360128) | i202222 | (57344 & i212222) | (458752 & i212222) | (3670016 & i212222);
        Map<KType, NavType<?>> map52222 = map2;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1162222 = function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172222 = function19;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1182222 = function110;
        Modifier modifier32222 = obj7;
        KClass<?> kClass52222 = kClass3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1192222 = function18;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1202222 = obj8;
        NavHost(navHostController, (NavGraph) rememberedValue, modifier32222, alignment32222, function1202222, function1162222, function1192222, function1172222, function1182222, startRestartGroup, i222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function111 = function1172222;
        function112 = function1182222;
        composer2 = startRestartGroup;
        function113 = function1202222;
        function114 = function1162222;
        function115 = function1192222;
        kClass4 = kClass52222;
        map3 = map52222;
        alignment2 = alignment32222;
        modifier2 = modifier32222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$21$lambda$20(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$23$lambda$22(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final Object obj, Modifier modifier, Alignment alignment, KClass<?> kClass, Map<KType, NavType<?>> map, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Object obj4;
        int i7;
        Object obj5;
        int i8;
        Object obj6;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        int i14;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function19;
        KClass<?> kClass2;
        Object obj7;
        Map<KType, NavType<?>> map2;
        Object obj8;
        int i15;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function110;
        Object obj9;
        boolean changed;
        Object rememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function111;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function112;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function114;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final KClass<?> kClass3;
        final Map<KType, NavType<?>> map3;
        final Alignment alignment2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1476019057);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)358@14617L135,356@14577L352:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj3 = alignment;
                i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj4 = kClass;
                    i4 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj5 = map;
                    } else {
                        obj5 = map;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj5) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        obj6 = function1;
                    } else {
                        obj6 = function1;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj6) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changedInstance(function13)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changedInstance(function14)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i16;
                        }
                        i16 = 268435456;
                        i4 |= i16;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (startRestartGroup.changedInstance(function15) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= startRestartGroup.changedInstance(function16) ? 32 : 16;
                    }
                    i13 = i12;
                    int i19 = i4;
                    if ((i4 & 306783379) == 306783378 || (i13 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "333@13797L58,339@13998L59");
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i18 == 0 ? Modifier.Companion : obj2;
                            Alignment topStart = i5 == 0 ? Alignment.Companion.getTopStart() : obj3;
                            if (i6 != 0) {
                                obj4 = null;
                            }
                            if (i7 != 0) {
                                obj5 = MapsKt.emptyMap();
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115092247, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj10) {
                                            EnterTransition NavHost$lambda$21$lambda$20;
                                            NavHost$lambda$21$lambda$20 = NavHostKt.NavHost$lambda$21$lambda$20((AnimatedContentTransitionScope) obj10);
                                            return NavHost$lambda$21$lambda$20;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                obj6 = (Function1) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            }
                            if (i9 == 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115085814, "CC(remember):NavHost.kt#9igjgp");
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj10) {
                                            ExitTransition NavHost$lambda$23$lambda$22;
                                            NavHost$lambda$23$lambda$22 = NavHostKt.NavHost$lambda$23$lambda$22((AnimatedContentTransitionScope) obj10);
                                            return NavHost$lambda$23$lambda$22;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                function17 = (Function1) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            } else {
                                function17 = function12;
                            }
                            if ((i3 & 256) == 0) {
                                i14 = i19 & (-234881025);
                                function18 = obj6;
                            } else {
                                function18 = function13;
                                i14 = i19;
                            }
                            if ((i3 & 512) == 0) {
                                i14 = (-1879048193) & i14;
                                function19 = function17;
                            } else {
                                function19 = function14;
                            }
                            Map<KType, NavType<?>> map4 = obj5;
                            kClass2 = obj4;
                            obj7 = topStart;
                            map2 = map4;
                            obj8 = companion;
                            i15 = i14;
                            if (i11 != 0) {
                                function110 = null;
                                startRestartGroup.endDefaults();
                                Alignment alignment3 = obj7;
                                if (ComposerKt.isTraceInProgress()) {
                                    obj9 = obj6;
                                    ComposerKt.traceEventStart(-1476019057, i15, i13, "androidx.navigation.compose.NavHost (NavHost.kt:355)");
                                } else {
                                    obj9 = obj6;
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                                changed = startRestartGroup.changed(kClass2) | startRestartGroup.changed(obj) | ((i13 & 112) == 32);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass2, map2);
                                    function16.invoke(navGraphBuilder);
                                    rememberedValue = navGraphBuilder.build();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i20 = i15 & 8078;
                                int i21 = i15 >> 6;
                                int i22 = ((i13 << 24) & 234881024) | (i21 & 29360128) | i20 | (57344 & i21) | (458752 & i21) | (3670016 & i21);
                                Map<KType, NavType<?>> map5 = map2;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116 = function17;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117 = function19;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function118 = function110;
                                Modifier modifier3 = obj8;
                                KClass<?> kClass4 = kClass2;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119 = function18;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120 = obj9;
                                NavHost(navHostController, (NavGraph) rememberedValue, modifier3, alignment3, function120, function116, function119, function117, function118, startRestartGroup, i22, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function111 = function117;
                                function112 = function118;
                                composer2 = startRestartGroup;
                                function113 = function120;
                                function114 = function116;
                                function115 = function119;
                                kClass3 = kClass4;
                                map3 = map5;
                                alignment2 = alignment3;
                                modifier2 = modifier3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            i15 = (i3 & 256) != 0 ? i19 & (-234881025) : i19;
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                            }
                            function17 = function12;
                            function18 = function13;
                            map2 = obj5;
                            obj8 = obj2;
                            function19 = function14;
                            kClass2 = obj4;
                            obj7 = obj3;
                        }
                        function110 = function15;
                        startRestartGroup.endDefaults();
                        Alignment alignment32 = obj7;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                        changed = startRestartGroup.changed(kClass2) | startRestartGroup.changed(obj) | ((i13 & 112) == 32);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass2, map2);
                        function16.invoke(navGraphBuilder2);
                        rememberedValue = navGraphBuilder2.build();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i202 = i15 & 8078;
                        int i212 = i15 >> 6;
                        int i222 = ((i13 << 24) & 234881024) | (i212 & 29360128) | i202 | (57344 & i212) | (458752 & i212) | (3670016 & i212);
                        Map<KType, NavType<?>> map52 = map2;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1162 = function17;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172 = function19;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1182 = function110;
                        Modifier modifier32 = obj8;
                        KClass<?> kClass42 = kClass2;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1192 = function18;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1202 = obj9;
                        NavHost(navHostController, (NavGraph) rememberedValue, modifier32, alignment32, function1202, function1162, function1192, function1172, function1182, startRestartGroup, i222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function111 = function1172;
                        function112 = function1182;
                        composer2 = startRestartGroup;
                        function113 = function1202;
                        function114 = function1162;
                        function115 = function1192;
                        kClass3 = kClass42;
                        map3 = map52;
                        alignment2 = alignment32;
                        modifier2 = modifier32;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function111 = function14;
                        kClass3 = obj4;
                        function113 = obj6;
                        modifier2 = obj2;
                        composer2 = startRestartGroup;
                        function114 = function12;
                        function115 = function13;
                        map3 = obj5;
                        alignment2 = obj3;
                        function112 = function15;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj10, Object obj11) {
                                Unit NavHost$lambda$25;
                                NavHost$lambda$25 = NavHostKt.NavHost$lambda$25(NavHostController.this, obj, modifier2, alignment2, kClass3, map3, function113, function114, function115, function111, function112, function16, i, i2, i3, (Composer) obj10, ((Integer) obj11).intValue());
                                return NavHost$lambda$25;
                            }
                        });
                        return;
                    }
                    return;
                }
                obj4 = kClass;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i13 = i12;
                int i192 = i4;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "333@13797L58,339@13998L59");
                if ((i & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                Map<KType, NavType<?>> map42 = obj5;
                kClass2 = obj4;
                obj7 = topStart;
                map2 = map42;
                obj8 = companion;
                i15 = i14;
                if (i11 != 0) {
                }
                function110 = function15;
                startRestartGroup.endDefaults();
                Alignment alignment322 = obj7;
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                changed = startRestartGroup.changed(kClass2) | startRestartGroup.changed(obj) | ((i13 & 112) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                NavGraphBuilder navGraphBuilder22 = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass2, map2);
                function16.invoke(navGraphBuilder22);
                rememberedValue = navGraphBuilder22.build();
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i2022 = i15 & 8078;
                int i2122 = i15 >> 6;
                int i2222 = ((i13 << 24) & 234881024) | (i2122 & 29360128) | i2022 | (57344 & i2122) | (458752 & i2122) | (3670016 & i2122);
                Map<KType, NavType<?>> map522 = map2;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11622 = function17;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function11722 = function19;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function11822 = function110;
                Modifier modifier322 = obj8;
                KClass<?> kClass422 = kClass2;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function11922 = function18;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function12022 = obj9;
                NavHost(navHostController, (NavGraph) rememberedValue, modifier322, alignment322, function12022, function11622, function11922, function11722, function11822, startRestartGroup, i2222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function111 = function11722;
                function112 = function11822;
                composer2 = startRestartGroup;
                function113 = function12022;
                function114 = function11622;
                function115 = function11922;
                kClass3 = kClass422;
                map3 = map522;
                alignment2 = alignment322;
                modifier2 = modifier322;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj3 = alignment;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj4 = kClass;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i13 = i12;
            int i1922 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "333@13797L58,339@13998L59");
            if ((i & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            Map<KType, NavType<?>> map422 = obj5;
            kClass2 = obj4;
            obj7 = topStart;
            map2 = map422;
            obj8 = companion;
            i15 = i14;
            if (i11 != 0) {
            }
            function110 = function15;
            startRestartGroup.endDefaults();
            Alignment alignment3222 = obj7;
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
            changed = startRestartGroup.changed(kClass2) | startRestartGroup.changed(obj) | ((i13 & 112) == 32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            NavGraphBuilder navGraphBuilder222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass2, map2);
            function16.invoke(navGraphBuilder222);
            rememberedValue = navGraphBuilder222.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i20222 = i15 & 8078;
            int i21222 = i15 >> 6;
            int i22222 = ((i13 << 24) & 234881024) | (i21222 & 29360128) | i20222 | (57344 & i21222) | (458752 & i21222) | (3670016 & i21222);
            Map<KType, NavType<?>> map5222 = map2;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116222 = function17;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function117222 = function19;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function118222 = function110;
            Modifier modifier3222 = obj8;
            KClass<?> kClass4222 = kClass2;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119222 = function18;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120222 = obj9;
            NavHost(navHostController, (NavGraph) rememberedValue, modifier3222, alignment3222, function120222, function116222, function119222, function117222, function118222, startRestartGroup, i22222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function111 = function117222;
            function112 = function118222;
            composer2 = startRestartGroup;
            function113 = function120222;
            function114 = function116222;
            function115 = function119222;
            kClass3 = kClass4222;
            map3 = map5222;
            alignment2 = alignment3222;
            modifier2 = modifier3222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        obj3 = alignment;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj4 = kClass;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i13 = i12;
        int i19222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "333@13797L58,339@13998L59");
        if ((i & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        Map<KType, NavType<?>> map4222 = obj5;
        kClass2 = obj4;
        obj7 = topStart;
        map2 = map4222;
        obj8 = companion;
        i15 = i14;
        if (i11 != 0) {
        }
        function110 = function15;
        startRestartGroup.endDefaults();
        Alignment alignment32222 = obj7;
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
        changed = startRestartGroup.changed(kClass2) | startRestartGroup.changed(obj) | ((i13 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        NavGraphBuilder navGraphBuilder2222 = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass2, map2);
        function16.invoke(navGraphBuilder2222);
        rememberedValue = navGraphBuilder2222.build();
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i202222 = i15 & 8078;
        int i212222 = i15 >> 6;
        int i222222 = ((i13 << 24) & 234881024) | (i212222 & 29360128) | i202222 | (57344 & i212222) | (458752 & i212222) | (3670016 & i212222);
        Map<KType, NavType<?>> map52222 = map2;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1162222 = function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1172222 = function19;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1182222 = function110;
        Modifier modifier32222 = obj8;
        KClass<?> kClass42222 = kClass2;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1192222 = function18;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1202222 = obj9;
        NavHost(navHostController, (NavGraph) rememberedValue, modifier32222, alignment32222, function1202222, function1162222, function1192222, function1172222, function1182222, startRestartGroup, i222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function111 = function1172222;
        function112 = function1182222;
        composer2 = startRestartGroup;
        function113 = function1202222;
        function114 = function1162222;
        function115 = function1192222;
        kClass3 = kClass42222;
        map3 = map52222;
        alignment2 = alignment32222;
        modifier2 = modifier32222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        NavGraph navGraph2;
        Object obj2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-957014592);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(2)393@15709L39:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            obj = navHostController;
        } else if ((i & 6) == 0) {
            obj = navHostController;
            i3 = (startRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            obj = navHostController;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            navGraph2 = navGraph;
        } else {
            navGraph2 = navGraph;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(navGraph2) ? 32 : 16;
            }
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.Companion : obj2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-957014592, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:393)");
                }
                NavHost(obj, navGraph2, companion, null, null, null, null, null, null, startRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier2 = obj2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        Unit NavHost$lambda$26;
                        NavHost$lambda$26 = NavHostKt.NavHost$lambda$26(NavHostController.this, navGraph, modifier2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        return NavHost$lambda$26;
                    }
                });
                return;
            }
            return;
        }
        obj2 = modifier;
        if ((i3 & 147) == 146) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        NavHost(obj, navGraph2, companion, null, null, null, null, null, null, startRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$28$lambda$27(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$30$lambda$29(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Composer composer, final int i, final int i2) {
        NavHostController navHostController2;
        int i3;
        NavGraph navGraph2;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Object obj4;
        Object obj5;
        int i7;
        Function1 function15;
        Object obj6;
        int i8;
        Function1 function16;
        Composer composer2;
        final Modifier modifier2;
        final Alignment alignment2;
        final Function1 function17;
        final Function1 function18;
        final Function1 function19;
        final Function1 function110;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1818191915);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,3,4)431@17441L199:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            navHostController2 = navHostController;
        } else {
            navHostController2 = navHostController;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(navHostController2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            navGraph2 = navGraph;
        } else {
            navGraph2 = navGraph;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(navGraph2) ? 32 : 16;
            }
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = alignment;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function1;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        obj4 = function12;
                        i3 |= startRestartGroup.changedInstance(obj4) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                obj5 = function13;
                                if (startRestartGroup.changedInstance(obj5)) {
                                    i10 = 1048576;
                                    i3 |= i10;
                                }
                            } else {
                                obj5 = function13;
                            }
                            i10 = 524288;
                            i3 |= i10;
                        } else {
                            obj5 = function13;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0 && startRestartGroup.changedInstance(function14)) {
                                i9 = 8388608;
                                i3 |= i9;
                            }
                            i9 = 4194304;
                            i3 |= i9;
                        }
                        int i12 = i3;
                        if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "420@16986L50,423@17133L51");
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i11 != 0 ? Modifier.Companion : obj;
                                if (i4 != 0) {
                                    obj2 = Alignment.Companion.getTopStart();
                                }
                                if (i5 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 769272135, "CC(remember):NavHost.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj7) {
                                                EnterTransition NavHost$lambda$28$lambda$27;
                                                NavHost$lambda$28$lambda$27 = NavHostKt.NavHost$lambda$28$lambda$27((AnimatedContentTransitionScope) obj7);
                                                return NavHost$lambda$28$lambda$27;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj3 = (Function1) rememberedValue;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 769276840, "CC(remember):NavHost.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj7) {
                                                ExitTransition NavHost$lambda$30$lambda$29;
                                                NavHost$lambda$30$lambda$29 = NavHostKt.NavHost$lambda$30$lambda$29((AnimatedContentTransitionScope) obj7);
                                                return NavHost$lambda$30$lambda$29;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj4 = (Function1) rememberedValue2;
                                }
                                if ((i2 & 64) != 0) {
                                    i7 = i12 & (-3670017);
                                    obj5 = obj3;
                                } else {
                                    i7 = i12;
                                }
                                if ((i2 & 128) != 0) {
                                    obj6 = companion;
                                    i8 = (-29360129) & i7;
                                    function16 = obj4;
                                    function15 = function16;
                                    Function1 function111 = obj5;
                                    Alignment alignment3 = obj2;
                                    Function1 function112 = obj3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1818191915, i8, -1, "androidx.navigation.compose.NavHost (NavHost.kt:430)");
                                    }
                                    composer2 = startRestartGroup;
                                    NavHost(navHostController2, navGraph2, obj6, alignment3, function112, function16, function111, function15, null, composer2, i8 & 33554430, 256);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = obj6;
                                    alignment2 = alignment3;
                                    function17 = function112;
                                    function18 = function16;
                                    function19 = function111;
                                    function110 = function15;
                                } else {
                                    function15 = function14;
                                    obj6 = companion;
                                    i8 = i7;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i8 = (i2 & 64) != 0 ? i12 & (-3670017) : i12;
                                if ((i2 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                function15 = function14;
                                obj6 = obj;
                            }
                            function16 = obj4;
                            Function1 function1112 = obj5;
                            Alignment alignment32 = obj2;
                            Function1 function1122 = obj3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            NavHost(navHostController2, navGraph2, obj6, alignment32, function1122, function16, function1112, function15, null, composer2, i8 & 33554430, 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = obj6;
                            alignment2 = alignment32;
                            function17 = function1122;
                            function18 = function16;
                            function19 = function1112;
                            function110 = function15;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier2 = obj;
                            alignment2 = obj2;
                            function17 = obj3;
                            function18 = obj4;
                            function19 = obj5;
                            function110 = function14;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj7, Object obj8) {
                                    Unit NavHost$lambda$31;
                                    NavHost$lambda$31 = NavHostKt.NavHost$lambda$31(NavHostController.this, navGraph, modifier2, alignment2, function17, function18, function19, function110, i, i2, (Composer) obj7, ((Integer) obj8).intValue());
                                    return NavHost$lambda$31;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = function12;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    int i122 = i3;
                    if ((i3 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "420@16986L50,423@17133L51");
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                }
                obj3 = function1;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                obj4 = function12;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                int i1222 = i3;
                if ((i3 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "420@16986L50,423@17133L51");
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
            }
            obj2 = alignment;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj3 = function1;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            obj4 = function12;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            int i12222 = i3;
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "420@16986L50,423@17133L51");
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj2 = alignment;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj3 = function1;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        obj4 = function12;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        int i122222 = i3;
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "420@16986L50,423@17133L51");
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$33$lambda$32(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$35$lambda$34(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:240:0x04a2, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L195;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier.Companion companion;
        int i5;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        Object obj3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function16;
        int i8;
        int i9;
        int i10;
        final Object obj4;
        Object obj5;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        final Alignment alignment2;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        final Modifier modifier2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function19;
        String str;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        int i11;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function111;
        ViewModelStoreOwner current;
        MutableFloatState mutableFloatState;
        MutableFloatState mutableFloatState2;
        final MutableState mutableState;
        Alignment alignment3;
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1;
        final Alignment alignment4;
        final Modifier modifier3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function112;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function113;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function114;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        int i12;
        DialogNavigator dialogNavigator;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function119;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120;
        MutableState mutableState2;
        DialogNavigator dialogNavigator2;
        int i13;
        MutableObjectFloatMap mutableObjectFloatMap;
        MutableState mutableState3;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-1964664536);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,3,4)491@19672L7,493@19756L7,508@20361L16,510@20399L36,511@20464L34,512@20552L987,512@20503L1036,539@21578L138,539@21545L171,545@21748L29,547@21837L16,550@21942L186,560@22223L46,729@30483L27:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(navGraph) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj = alignment;
                    i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj2 = function1;
                        i3 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            obj3 = function12;
                            i3 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
                            if ((i & 1572864) != 0) {
                                function16 = function13;
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changedInstance(function16)) ? 1048576 : 524288;
                            } else {
                                function16 = function13;
                            }
                            if ((i & 12582912) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changedInstance(function14)) {
                                    i14 = 8388608;
                                    i3 |= i14;
                                }
                                i14 = 4194304;
                                i3 |= i14;
                            }
                            i8 = i2 & 256;
                            if (i8 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changedInstance(function15) ? 67108864 : 33554432;
                                i10 = i3;
                                if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i4 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        Alignment topStart = i5 != 0 ? Alignment.Companion.getTopStart() : alignment;
                                        if (i6 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743001538, "CC(remember):NavHost.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda0
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj6) {
                                                        EnterTransition NavHost$lambda$33$lambda$32;
                                                        NavHost$lambda$33$lambda$32 = NavHostKt.NavHost$lambda$33$lambda$32((AnimatedContentTransitionScope) obj6);
                                                        return NavHost$lambda$33$lambda$32;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            obj4 = (Function1) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            obj4 = obj2;
                                        }
                                        if (i7 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743007971, "CC(remember):NavHost.kt#9igjgp");
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                                rememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda24
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj6) {
                                                        ExitTransition NavHost$lambda$35$lambda$34;
                                                        NavHost$lambda$35$lambda$34 = NavHostKt.NavHost$lambda$35$lambda$34((AnimatedContentTransitionScope) obj6);
                                                        return NavHost$lambda$35$lambda$34;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            obj5 = (Function1) rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            obj5 = obj3;
                                        }
                                        if ((i2 & 64) != 0) {
                                            i10 &= -3670017;
                                            function16 = obj4;
                                        }
                                        if ((i2 & 128) != 0) {
                                            i10 &= -29360129;
                                            function17 = obj5;
                                        } else {
                                            function17 = function14;
                                        }
                                        alignment2 = topStart;
                                        function18 = function16;
                                        modifier2 = companion;
                                        function19 = obj5;
                                        str = "CC(remember):NavHost.kt#9igjgp";
                                        function110 = function17;
                                        i11 = i10;
                                        if (i9 != 0) {
                                            function111 = null;
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1964664536, i11, -1, "androidx.navigation.compose.NavHost (NavHost.kt:489)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
                                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                                            if (current != null) {
                                                throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
                                            }
                                            navHostController.setViewModelStore(current.getViewModelStore());
                                            navHostController.setGraph(navGraph);
                                            Navigator navigator = navHostController.getNavigatorProvider().getNavigator(ComposeNavigator.NAME);
                                            final ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
                                            if (composeNavigator == null) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                                                if (endRestartGroup != null) {
                                                    final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function121 = function18;
                                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda25
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(Object obj6, Object obj7) {
                                                            Unit NavHost$lambda$37;
                                                            NavHost$lambda$37 = NavHostKt.NavHost$lambda$37(NavHostController.this, navGraph, modifier2, alignment2, obj4, function19, function121, function110, function111, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                                            return NavHost$lambda$37;
                                                        }
                                                    });
                                                    return;
                                                }
                                                return;
                                            }
                                            final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function122 = function18;
                                            final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function123 = obj4;
                                            final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function124 = function19;
                                            final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function125 = function110;
                                            final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function126 = function111;
                                            Modifier modifier4 = modifier2;
                                            State collectAsState = SnapshotStateKt.collectAsState(composeNavigator.getBackStack(), null, startRestartGroup, 0, 1);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743049772, str);
                                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                                rememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            }
                                            MutableFloatState mutableFloatState3 = (MutableFloatState) rememberedValue3;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743051850, str);
                                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                                mutableFloatState = mutableFloatState3;
                                                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            } else {
                                                mutableFloatState = mutableFloatState3;
                                            }
                                            MutableState mutableState4 = (MutableState) rememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            boolean z = NavHost$lambda$38(collectAsState).size() > 1;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743055619, str);
                                            boolean changed = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(composeNavigator);
                                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                                            if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                                                mutableFloatState2 = mutableFloatState;
                                                mutableState = mutableState4;
                                                alignment3 = alignment2;
                                                navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(composeNavigator, collectAsState, mutableFloatState, mutableState4, null);
                                                startRestartGroup.updateRememberedValue(navHostKt$NavHost$25$1);
                                            } else {
                                                mutableFloatState2 = mutableFloatState;
                                                alignment3 = alignment2;
                                                navHostKt$NavHost$25$1 = rememberedValue5;
                                                mutableState = mutableState4;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            int i15 = i11;
                                            NavComposeUtils_androidKt.PredictiveBackHandler(z, navHostKt$NavHost$25$1, startRestartGroup, 0, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743087602, str);
                                            boolean changedInstance = startRestartGroup.changedInstance(navHostController) | startRestartGroup.changedInstance(lifecycleOwner);
                                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                                            if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                                                rememberedValue6 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda26
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj6) {
                                                        DisposableEffectResult NavHost$lambda$48$lambda$47;
                                                        NavHost$lambda$48$lambda$47 = NavHostKt.NavHost$lambda$48$lambda$47(NavHostController.this, lifecycleOwner, (DisposableEffectScope) obj6);
                                                        return NavHost$lambda$48$lambda$47;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue6);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) rememberedValue6, startRestartGroup, 0);
                                            final SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
                                            final State collectAsState2 = SnapshotStateKt.collectAsState(navHostController.getVisibleEntries(), null, startRestartGroup, 0, 1);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743099298, str);
                                            Object rememberedValue7 = startRestartGroup.rememberedValue();
                                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                                rememberedValue7 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda27
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        List NavHost$lambda$52$lambda$51;
                                                        NavHost$lambda$52$lambda$51 = NavHostKt.NavHost$lambda$52$lambda$51(State.this);
                                                        return NavHost$lambda$52$lambda$51;
                                                    }
                                                });
                                                startRestartGroup.updateRememberedValue(rememberedValue7);
                                            }
                                            final State state = (State) rememberedValue7;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List<? extends Object>) NavHost$lambda$53(state));
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743108150, str);
                                            Object rememberedValue8 = startRestartGroup.rememberedValue();
                                            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                                                rememberedValue8 = ObjectFloatMapKt.mutableObjectFloatMapOf();
                                                startRestartGroup.updateRememberedValue(rememberedValue8);
                                            }
                                            final MutableObjectFloatMap mutableObjectFloatMap2 = (MutableObjectFloatMap) rememberedValue8;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            if (navBackStackEntry != null) {
                                                startRestartGroup.startReplaceGroup(-1797897130);
                                                ComposerKt.sourceInformation(startRestartGroup, "563@22403L597,577@23098L597,593@23826L301,601@24160L146,601@24137L169,607@24338L348,614@24713L52,655@26687L1175,680@27919L9,681@27939L1465,653@26619L2785,708@29477L792,708@29413L856");
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743114461, str);
                                                boolean changedInstance2 = startRestartGroup.changedInstance(composeNavigator) | ((((i15 & 3670016) ^ 1572864) > 1048576 && startRestartGroup.changed(function122)) || (i15 & 1572864) == 1048576) | ((i15 & 57344) == 16384);
                                                Object rememberedValue9 = startRestartGroup.rememberedValue();
                                                if (changedInstance2 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                                    rememberedValue9 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda28
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj6) {
                                                            EnterTransition NavHost$lambda$58$lambda$57;
                                                            NavHost$lambda$58$lambda$57 = NavHostKt.NavHost$lambda$58$lambda$57(ComposeNavigator.this, function122, function123, mutableState, (AnimatedContentTransitionScope) obj6);
                                                            return NavHost$lambda$58$lambda$57;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                                }
                                                final Function1 function127 = (Function1) rememberedValue9;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743136701, str);
                                                function114 = function123;
                                                boolean changedInstance3 = startRestartGroup.changedInstance(composeNavigator) | ((((i15 & 29360128) ^ 12582912) > 8388608 && startRestartGroup.changed(function125)) || (i15 & 12582912) == 8388608) | ((i15 & 458752) == 131072);
                                                Object rememberedValue10 = startRestartGroup.rememberedValue();
                                                if (changedInstance3 || rememberedValue10 == Composer.Companion.getEmpty()) {
                                                    rememberedValue10 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda29
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj6) {
                                                            ExitTransition NavHost$lambda$62$lambda$61;
                                                            NavHost$lambda$62$lambda$61 = NavHostKt.NavHost$lambda$62$lambda$61(ComposeNavigator.this, function125, function124, mutableState, (AnimatedContentTransitionScope) obj6);
                                                            return NavHost$lambda$62$lambda$61;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                                }
                                                final Function1 function128 = (Function1) rememberedValue10;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743159701, str);
                                                function112 = function125;
                                                boolean z2 = (i15 & 234881024) == 67108864;
                                                Object rememberedValue11 = startRestartGroup.rememberedValue();
                                                if (z2 || rememberedValue11 == Composer.Companion.getEmpty()) {
                                                    rememberedValue11 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj6) {
                                                            SizeTransform NavHost$lambda$65$lambda$64;
                                                            NavHost$lambda$65$lambda$64 = NavHostKt.NavHost$lambda$65$lambda$64(Function1.this, (AnimatedContentTransitionScope) obj6);
                                                            return NavHost$lambda$65$lambda$64;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue11);
                                                }
                                                final Function1 function129 = (Function1) rememberedValue11;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                function113 = function126;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743170234, str);
                                                boolean changedInstance4 = startRestartGroup.changedInstance(composeNavigator);
                                                Object rememberedValue12 = startRestartGroup.rememberedValue();
                                                if (changedInstance4) {
                                                    mutableState2 = mutableState;
                                                } else {
                                                    mutableState2 = mutableState;
                                                }
                                                rememberedValue12 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj6) {
                                                        DisposableEffectResult NavHost$lambda$69$lambda$68;
                                                        NavHost$lambda$69$lambda$68 = NavHostKt.NavHost$lambda$69$lambda$68(State.this, composeNavigator, (DisposableEffectScope) obj6);
                                                        return NavHost$lambda$69$lambda$68;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue12);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.DisposableEffect((Object) true, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue12, startRestartGroup, 6);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743176132, str);
                                                Object rememberedValue13 = startRestartGroup.rememberedValue();
                                                if (rememberedValue13 == Composer.Companion.getEmpty()) {
                                                    rememberedValue13 = new SeekableTransitionState(navBackStackEntry);
                                                    startRestartGroup.updateRememberedValue(rememberedValue13);
                                                }
                                                final SeekableTransitionState seekableTransitionState = (SeekableTransitionState) rememberedValue13;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                function115 = function122;
                                                Transition rememberTransition = TransitionKt.rememberTransition(seekableTransitionState, "entry", startRestartGroup, SeekableTransitionState.$stable | 48, 0);
                                                if (NavHost$lambda$43(mutableState2)) {
                                                    startRestartGroup.startReplaceGroup(-1795663766);
                                                    ComposerKt.sourceInformation(startRestartGroup, "617@24836L159,617@24811L184");
                                                    Float valueOf = Float.valueOf(NavHost$lambda$40(mutableFloatState2));
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743191879, str);
                                                    boolean changed2 = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(seekableTransitionState);
                                                    NavHostKt$NavHost$28$1 rememberedValue14 = startRestartGroup.rememberedValue();
                                                    if (changed2 || rememberedValue14 == Composer.Companion.getEmpty()) {
                                                        rememberedValue14 = new NavHostKt$NavHost$28$1(seekableTransitionState, collectAsState, mutableFloatState2, null);
                                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue14, startRestartGroup, 0);
                                                    startRestartGroup.endReplaceGroup();
                                                    i13 = 0;
                                                    dialogNavigator2 = null;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-1795408729);
                                                    ComposerKt.sourceInformation(startRestartGroup, "622@25056L1532,622@25025L1563");
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743200292, str);
                                                    boolean changedInstance5 = startRestartGroup.changedInstance(seekableTransitionState) | startRestartGroup.changedInstance(navBackStackEntry) | startRestartGroup.changed(rememberTransition);
                                                    NavHostKt$NavHost$29$1 rememberedValue15 = startRestartGroup.rememberedValue();
                                                    if (changedInstance5 || rememberedValue15 == Composer.Companion.getEmpty()) {
                                                        dialogNavigator2 = null;
                                                        rememberedValue15 = new NavHostKt$NavHost$29$1(seekableTransitionState, navBackStackEntry, rememberTransition, null);
                                                        startRestartGroup.updateRememberedValue(rememberedValue15);
                                                    } else {
                                                        dialogNavigator2 = null;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    i13 = 0;
                                                    EffectsKt.LaunchedEffect(navBackStackEntry, (Function2) rememberedValue15, startRestartGroup, 0);
                                                    startRestartGroup.endReplaceGroup();
                                                }
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743252127, str);
                                                boolean changedInstance6 = startRestartGroup.changedInstance(mutableObjectFloatMap2) | startRestartGroup.changedInstance(composeNavigator) | startRestartGroup.changed(function127) | startRestartGroup.changed(function128) | startRestartGroup.changed(function129);
                                                Object rememberedValue16 = startRestartGroup.rememberedValue();
                                                if (changedInstance6 || rememberedValue16 == Composer.Companion.getEmpty()) {
                                                    final MutableState mutableState5 = mutableState2;
                                                    final ComposeNavigator composeNavigator2 = composeNavigator;
                                                    rememberedValue16 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj6) {
                                                            ContentTransform NavHost$lambda$75$lambda$74;
                                                            NavHost$lambda$75$lambda$74 = NavHostKt.NavHost$lambda$75$lambda$74(MutableObjectFloatMap.this, composeNavigator2, function127, function128, function129, state, mutableState5, (AnimatedContentTransitionScope) obj6);
                                                            return NavHost$lambda$75$lambda$74;
                                                        }
                                                    };
                                                    mutableObjectFloatMap = mutableObjectFloatMap2;
                                                    mutableState3 = mutableState5;
                                                    startRestartGroup.updateRememberedValue(rememberedValue16);
                                                } else {
                                                    mutableState3 = mutableState2;
                                                    mutableObjectFloatMap = mutableObjectFloatMap2;
                                                }
                                                Function1 function130 = (Function1) rememberedValue16;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743290385, str);
                                                Object rememberedValue17 = startRestartGroup.rememberedValue();
                                                if (rememberedValue17 == Composer.Companion.getEmpty()) {
                                                    rememberedValue17 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda11
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj6) {
                                                            Object id;
                                                            id = ((NavBackStackEntry) obj6).getId();
                                                            return id;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue17);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final MutableState mutableState6 = mutableState3;
                                                alignment4 = alignment3;
                                                i12 = i13;
                                                dialogNavigator = dialogNavigator2;
                                                AnimatedContentKt.AnimatedContent(rememberTransition, modifier4, function130, alignment4, (Function1) rememberedValue17, ComposableLambdaKt.rememberComposableLambda(820763100, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$32
                                                    @Override // kotlin.jvm.functions.Function4
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer3, Integer num) {
                                                        invoke(animatedContentScope, navBackStackEntry2, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    /* JADX WARN: Type inference failed for: r0v10 */
                                                    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object] */
                                                    /* JADX WARN: Type inference failed for: r0v9 */
                                                    public final void invoke(final AnimatedContentScope animatedContentScope, final NavBackStackEntry navBackStackEntry2, Composer composer3, int i16) {
                                                        boolean NavHost$lambda$43;
                                                        List NavHost$lambda$53;
                                                        ?? r0;
                                                        ComposerKt.sourceInformation(composer3, "C:NavHost.kt#opm8kd");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(820763100, i16, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:688)");
                                                        }
                                                        boolean areEqual = Intrinsics.areEqual(seekableTransitionState.getCurrentState(), navBackStackEntry);
                                                        NavHost$lambda$43 = NavHostKt.NavHost$lambda$43(mutableState6);
                                                        if (!NavHost$lambda$43 && !areEqual) {
                                                            NavHost$lambda$53 = NavHostKt.NavHost$lambda$53(state);
                                                            ListIterator listIterator = NavHost$lambda$53.listIterator(NavHost$lambda$53.size());
                                                            while (true) {
                                                                if (!listIterator.hasPrevious()) {
                                                                    r0 = 0;
                                                                    break;
                                                                }
                                                                r0 = listIterator.previous();
                                                                if (Intrinsics.areEqual(navBackStackEntry2, (NavBackStackEntry) r0)) {
                                                                    break;
                                                                }
                                                            }
                                                            navBackStackEntry2 = r0;
                                                        }
                                                        if (navBackStackEntry2 == null) {
                                                            composer3.startReplaceGroup(105930796);
                                                        } else {
                                                            composer3.startReplaceGroup(-1520603531);
                                                            ComposerKt.sourceInformation(composer3, "701@29218L176,701@29177L217");
                                                            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, rememberSaveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-1263531443, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$32.1
                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                    invoke(composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i17) {
                                                                    ComposerKt.sourceInformation(composer4, "C702@29295L85:NavHost.kt#opm8kd");
                                                                    if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1263531443, i17, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:702)");
                                                                        }
                                                                        NavDestination destination = NavBackStackEntry.this.getDestination();
                                                                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                                        ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke(animatedContentScope, NavBackStackEntry.this, composer4, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, startRestartGroup, 54), startRestartGroup, ((i15 >> 3) & 112) | 221184 | (i15 & 7168), 0);
                                                modifier3 = modifier4;
                                                Object currentState = rememberTransition.getCurrentState();
                                                Object targetState = rememberTransition.getTargetState();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1743341024, str);
                                                boolean changed3 = startRestartGroup.changed(rememberTransition) | startRestartGroup.changedInstance(navHostController) | startRestartGroup.changedInstance(composeNavigator) | startRestartGroup.changedInstance(mutableObjectFloatMap);
                                                NavHostKt$NavHost$33$1 rememberedValue18 = startRestartGroup.rememberedValue();
                                                if (changed3 || rememberedValue18 == Composer.Companion.getEmpty()) {
                                                    rememberedValue18 = new NavHostKt$NavHost$33$1(rememberTransition, navHostController, mutableObjectFloatMap, state, composeNavigator, null);
                                                    startRestartGroup.updateRememberedValue(rememberedValue18);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.LaunchedEffect(currentState, targetState, (Function2) rememberedValue18, startRestartGroup, i12);
                                                startRestartGroup.endReplaceGroup();
                                            } else {
                                                alignment4 = alignment3;
                                                modifier3 = modifier4;
                                                function112 = function125;
                                                function113 = function126;
                                                function114 = function123;
                                                function115 = function122;
                                                i12 = 0;
                                                dialogNavigator = null;
                                                startRestartGroup.startReplaceGroup(-1790236038);
                                                startRestartGroup.endReplaceGroup();
                                            }
                                            Navigator navigator2 = navHostController.getNavigatorProvider().getNavigator(DialogNavigator.NAME);
                                            DialogNavigator dialogNavigator3 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator;
                                            if (dialogNavigator3 == null) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                                                if (endRestartGroup2 != null) {
                                                    final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function131 = function114;
                                                    final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function132 = function112;
                                                    final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function133 = function113;
                                                    final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function134 = function115;
                                                    endRestartGroup2.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda22
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(Object obj6, Object obj7) {
                                                            Unit NavHost$lambda$79;
                                                            NavHost$lambda$79 = NavHostKt.NavHost$lambda$79(NavHostController.this, navGraph, modifier3, alignment4, function131, function124, function134, function132, function133, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                                            return NavHost$lambda$79;
                                                        }
                                                    });
                                                    return;
                                                }
                                                return;
                                            }
                                            function116 = function124;
                                            function117 = function114;
                                            function118 = function112;
                                            function119 = function113;
                                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function135 = function115;
                                            DialogHostKt.DialogHost(dialogNavigator3, startRestartGroup, i12);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2 = startRestartGroup;
                                            function120 = function135;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 64) != 0) {
                                            i10 &= -3670017;
                                        }
                                        if ((i2 & 128) != 0) {
                                            i10 &= -29360129;
                                        }
                                        alignment2 = alignment;
                                        function110 = function14;
                                        function18 = function16;
                                        modifier2 = companion;
                                        obj4 = obj2;
                                        function19 = obj3;
                                        i11 = i10;
                                        str = "CC(remember):NavHost.kt#9igjgp";
                                    }
                                    function111 = function15;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final LifecycleOwner lifecycleOwner2 = (LifecycleOwner) consume2;
                                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                                    if (current != null) {
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    function118 = function14;
                                    composer2 = startRestartGroup;
                                    alignment4 = obj;
                                    function117 = obj2;
                                    function119 = function15;
                                    function120 = function16;
                                    modifier3 = companion;
                                    function116 = obj3;
                                }
                                ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
                                if (endRestartGroup3 != null) {
                                    endRestartGroup3.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda23
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj6, Object obj7) {
                                            Unit NavHost$lambda$80;
                                            NavHost$lambda$80 = NavHostKt.NavHost$lambda$80(NavHostController.this, navGraph, modifier3, alignment4, function117, function116, function120, function118, function119, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                            return NavHost$lambda$80;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i9 = i8;
                            i10 = i3;
                            if ((i3 & 38347923) == 38347922) {
                            }
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
                            if ((i & 1) != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i2 & 64) != 0) {
                            }
                            if ((i2 & 128) != 0) {
                            }
                            alignment2 = topStart;
                            function18 = function16;
                            modifier2 = companion;
                            function19 = obj5;
                            str = "CC(remember):NavHost.kt#9igjgp";
                            function110 = function17;
                            i11 = i10;
                            if (i9 != 0) {
                            }
                            function111 = function15;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final LifecycleOwner lifecycleOwner22 = (LifecycleOwner) consume22;
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                            if (current != null) {
                            }
                        }
                        obj3 = function12;
                        if ((i & 1572864) != 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i3;
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if ((i2 & 128) != 0) {
                        }
                        alignment2 = topStart;
                        function18 = function16;
                        modifier2 = companion;
                        function19 = obj5;
                        str = "CC(remember):NavHost.kt#9igjgp";
                        function110 = function17;
                        i11 = i10;
                        if (i9 != 0) {
                        }
                        function111 = function15;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume222 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final LifecycleOwner lifecycleOwner222 = (LifecycleOwner) consume222;
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                        if (current != null) {
                        }
                    }
                    obj2 = function1;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    obj3 = function12;
                    if ((i & 1572864) != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    alignment2 = topStart;
                    function18 = function16;
                    modifier2 = companion;
                    function19 = obj5;
                    str = "CC(remember):NavHost.kt#9igjgp";
                    function110 = function17;
                    i11 = i10;
                    if (i9 != 0) {
                    }
                    function111 = function15;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2222 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final LifecycleOwner lifecycleOwner2222 = (LifecycleOwner) consume2222;
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current != null) {
                    }
                }
                obj = alignment;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                obj2 = function1;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                obj3 = function12;
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3;
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                alignment2 = topStart;
                function18 = function16;
                modifier2 = companion;
                function19 = obj5;
                str = "CC(remember):NavHost.kt#9igjgp";
                function110 = function17;
                i11 = i10;
                if (i9 != 0) {
                }
                function111 = function15;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22222 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final LifecycleOwner lifecycleOwner22222 = (LifecycleOwner) consume22222;
                current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj = alignment;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            obj2 = function1;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            obj3 = function12;
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            alignment2 = topStart;
            function18 = function16;
            modifier2 = companion;
            function19 = obj5;
            str = "CC(remember):NavHost.kt#9igjgp";
            function110 = function17;
            i11 = i10;
            if (i9 != 0) {
            }
            function111 = function15;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222222 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LifecycleOwner lifecycleOwner222222 = (LifecycleOwner) consume222222;
            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj = alignment;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        obj2 = function1;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        obj3 = function12;
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        ComposerKt.sourceInformation(startRestartGroup, "468@18891L58,474@19092L59");
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        alignment2 = topStart;
        function18 = function16;
        modifier2 = companion;
        function19 = obj5;
        str = "CC(remember):NavHost.kt#9igjgp";
        function110 = function17;
        i11 = i10;
        if (i9 != 0) {
        }
        function111 = function15;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222222 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final LifecycleOwner lifecycleOwner2222222 = (LifecycleOwner) consume2222222;
        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavHost$lambda$40(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NavHost$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavHost$lambda$44(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult NavHost$lambda$48$lambda$47(NavHostController navHostController, LifecycleOwner lifecycleOwner, DisposableEffectScope disposableEffectScope) {
        navHostController.setLifecycleOwner(lifecycleOwner);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List NavHost$lambda$52$lambda$51(State state) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : NavHost$lambda$49(state)) {
            if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$58$lambda$57(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        EnterTransition enterTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EnterTransition createPopEnterTransition = createPopEnterTransition(it.next(), animatedContentTransitionScope);
                if (createPopEnterTransition != null) {
                    enterTransition = createPopEnterTransition;
                    break;
                }
            }
            return enterTransition == null ? (EnterTransition) function1.invoke(animatedContentTransitionScope) : enterTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.Companion.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            EnterTransition createEnterTransition = createEnterTransition(it2.next(), animatedContentTransitionScope);
            if (createEnterTransition != null) {
                enterTransition = createEnterTransition;
                break;
            }
        }
        return enterTransition == null ? (EnterTransition) function12.invoke(animatedContentTransitionScope) : enterTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$62$lambda$61(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        ExitTransition exitTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ExitTransition createPopExitTransition = createPopExitTransition(it.next(), animatedContentTransitionScope);
                if (createPopExitTransition != null) {
                    exitTransition = createPopExitTransition;
                    break;
                }
            }
            return exitTransition == null ? (ExitTransition) function1.invoke(animatedContentTransitionScope) : exitTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.Companion.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ExitTransition createExitTransition = createExitTransition(it2.next(), animatedContentTransitionScope);
            if (createExitTransition != null) {
                exitTransition = createExitTransition;
                break;
            }
        }
        return exitTransition == null ? (ExitTransition) function12.invoke(animatedContentTransitionScope) : exitTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SizeTransform NavHost$lambda$65$lambda$64(Function1 function1, AnimatedContentTransitionScope animatedContentTransitionScope) {
        SizeTransform sizeTransform;
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        Iterator<NavDestination> it = NavDestination.Companion.getHierarchy((ComposeNavigator.Destination) destination).iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeTransform = null;
                break;
            }
            sizeTransform = createSizeTransform(it.next(), animatedContentTransitionScope);
            if (sizeTransform != null) {
                break;
            }
        }
        if (sizeTransform == null) {
            if (function1 != null) {
                return (SizeTransform) function1.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        return sizeTransform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform NavHost$lambda$75$lambda$74(MutableObjectFloatMap mutableObjectFloatMap, ComposeNavigator composeNavigator, Function1 function1, Function1 function12, Function1 function13, State state, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        float f;
        if (NavHost$lambda$53(state).contains(animatedContentTransitionScope.getInitialState())) {
            String id = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId();
            int findKeyIndex = mutableObjectFloatMap.findKeyIndex(id);
            if (findKeyIndex >= 0) {
                f = mutableObjectFloatMap.values[findKeyIndex];
            } else {
                mutableObjectFloatMap.set(id, 0.0f);
                f = 0.0f;
            }
            if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId())) {
                f = (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) ? f - 1.0f : f + 1.0f;
            }
            mutableObjectFloatMap.set(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), f);
            return new ContentTransform((EnterTransition) function1.invoke(animatedContentTransitionScope), (ExitTransition) function12.invoke(animatedContentTransitionScope), f, (SizeTransform) function13.invoke(animatedContentTransitionScope));
        }
        return AnimatedContentKt.togetherWith(EnterTransition.Companion.getNone(), ExitTransition.Companion.getNone());
    }

    private static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    private static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    private static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    private static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    private static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        } else {
            return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$38(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    private static final List<NavBackStackEntry> NavHost$lambda$49(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$53(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult NavHost$lambda$69$lambda$68(final State state, final ComposeNavigator composeNavigator, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$69$lambda$68$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                List<NavBackStackEntry> NavHost$lambda$53;
                NavHost$lambda$53 = NavHostKt.NavHost$lambda$53(State.this);
                for (NavBackStackEntry navBackStackEntry : NavHost$lambda$53) {
                    composeNavigator.onTransitionComplete(navBackStackEntry);
                }
            }
        };
    }
}

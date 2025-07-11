package androidx.navigation.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.NavUriKt;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.SupportingPane;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializersKt;
/* compiled from: NavControllerImpl.kt */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u008e\u00022\u00020\u0001:\u0002\u008e\u0002B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,H\u0000¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u0004\u0018\u00010,2\u0006\u0010D\u001a\u00020,H\u0000¢\u0006\u0002\bHJm\u0010\u0088\u0001\u001a\u00020\u00062\u000f\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020,012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012$\b\u0002\u0010\u008f\u0001\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u00060yH\u0000¢\u0006\u0003\b\u0090\u0001JZ\u0010\u0091\u0001\u001a\u00020\u00062\u000f\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t2\u0007\u0010\u0082\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0086\u00012%\b\u0002\u0010\u008f\u0001\u001a\u001e\u0012\u0014\u0012\u00120,¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\u00060yH\u0000¢\u0006\u0003\b\u0093\u0001J$\u0010\u0094\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0006\u0010|\u001a\u00020,H\u0000¢\u0006\u0003\b\u0096\u0001J)\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020u2\u000f\u0010\u0099\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\b\u009a\u0001J>\u0010\u009b\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0007\u0010\u0082\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0086\u00012\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b\u009d\u0001J4\u0010\u009e\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0007\u0010\u009f\u0001\u001a\u00020,2\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b \u0001J\u0018\u0010¡\u0001\u001a\u00020\u00062\u0007\u0010\u009f\u0001\u001a\u00020,H\u0000¢\u0006\u0003\b¢\u0001J\u0018\u0010£\u0001\u001a\u00020\u00062\u0007\u0010¤\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b¥\u0001J\u0018\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010¤\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b§\u0001J\u0010\u0010¨\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J#\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J-\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J-\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020K2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J@\u0010¨\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J<\u0010¨\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0006\b©\u0001\u0010¯\u0001J/\u0010\u0091\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b\u0093\u0001J>\u0010\u0091\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0006\b\u0093\u0001\u0010¯\u0001J-\u0010\u0091\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020K2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b\u0093\u0001J@\u0010°\u0001\u001a\u00030\u0086\u00012\u0011\u0010±\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030t012\u0007\u0010²\u0001\u001a\u00020u2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b³\u0001J'\u0010´\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020,2\r\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b¶\u0001J5\u0010·\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020,2\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u00012\u000f\b\u0002\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020N0+H\u0000¢\u0006\u0003\b¹\u0001J\u0019\u0010º\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b»\u0001J\u0019\u0010º\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b»\u0001J,\u0010º\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u0001H\u0000¢\u0006\u0003\b»\u0001J(\u0010º\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0019\u0010½\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b¾\u0001J\u0019\u0010½\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b¾\u0001J\u0010\u0010Á\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\bÂ\u0001J\u000f\u0010Ã\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\bÄ\u0001J\u0015\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020,01H\u0000¢\u0006\u0003\bÆ\u0001J'\u0010Ç\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u000f\u0010È\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0002\b\u001bJ \u0010É\u0001\u001a\u00020\u00062\u000f\u0010È\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bÊ\u0001J\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010K2\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\bÎ\u0001J'\u0010Ò\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010ª\u0001\u001a\u00020J2\u000b\b\u0002\u0010Ó\u0001\u001a\u0004\u0018\u00010uH\u0000¢\u0006\u0003\bÔ\u0001J:\u0010Õ\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010\u0098\u0001\u001a\u00020u2\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010Ö\u0001\u001a\u00030\u0086\u00012\u000b\b\u0002\u0010Ó\u0001\u001a\u0004\u0018\u00010uH\u0000¢\u0006\u0003\b×\u0001J\u001a\u0010Ò\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\bÔ\u0001J\u000f\u0010Ø\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÙ\u0001J'\u0010Ú\u0001\u001a\u00020K\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u001e\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u0001H\u0000¢\u0006\u0003\bà\u0001J*\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\bà\u0001J6\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001J\u0019\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u0001H\u0000¢\u0006\u0003\bà\u0001J%\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\bà\u0001J1\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001JA\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001J$\u0010å\u0001\u001a\u00030\u0086\u00012\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0002J<\u0010æ\u0001\u001a\u00030\u0086\u00012\u0007\u0010ç\u0001\u001a\u00020J2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\u0013\u0010æ\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0002JB\u0010è\u0001\u001a\u00030\u0086\u00012\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020,012\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J \u0010é\u0001\u001a\b\u0012\u0004\u0012\u00020,012\u000f\u0010ê\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010+H\u0002J<\u0010ë\u0001\u001a\u00020\u00062\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ì\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u0006\u0010|\u001a\u00020,2\u000f\b\u0002\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020,01H\u0002J4\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010¬\u0001\u001a\u00020K2\u001a\u0010î\u0001\u001a\u0015\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020\u00060y¢\u0006\u0003\bð\u0001H\u0000¢\u0006\u0003\bà\u0001J2\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010¬\u0001\u001a\u00020K2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001JC\u0010Ý\u0001\u001a\u00020\u0006\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\u001a\u0010î\u0001\u001a\u0015\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020\u00060y¢\u0006\u0003\bð\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010ñ\u0001JA\u0010Ý\u0001\u001a\u00020\u0006\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010ò\u0001J\u0017\u0010\u0092\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bó\u0001J \u0010ô\u0001\u001a\u00020\u00062\u000f\u0010õ\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bö\u0001J\u0018\u0010÷\u0001\u001a\u00020\u00062\u0007\u0010ø\u0001\u001a\u00020QH\u0001¢\u0006\u0003\bù\u0001J\u0019\u0010ú\u0001\u001a\u00020\u00062\b\u0010û\u0001\u001a\u00030ü\u0001H\u0000¢\u0006\u0003\bý\u0001J\u0019\u0010þ\u0001\u001a\u00030ÿ\u00012\u0007\u0010\u0080\u0002\u001a\u00020JH\u0000¢\u0006\u0003\b\u0081\u0002J\u0018\u0010\u0082\u0002\u001a\u00020,2\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b\u0083\u0002J\u0018\u0010\u0082\u0002\u001a\u00020,2\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b\u0083\u0002J+\u0010\u0082\u0002\u001a\u00020,\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u0001H\u0000¢\u0006\u0003\b\u0083\u0002J'\u0010\u0082\u0002\u001a\u00020,\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00148A@AX\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u000e\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0018\u00010$X\u0080\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0100X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\"\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01058AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0100X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R \u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0105X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00107R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\"\u0010I\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0006\u0012\u0004\u0018\u00010K0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010?R&\u0010M\u001a\u0014\u0012\u0004\u0012\u00020K\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0+0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010?R\"\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010Q@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001c\u0010`\u001a\u00020a8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020kX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u00020k2\u0006\u0010p\u001a\u00020k8@@AX\u0080\u000e¢\u0006\f\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR,\u0010s\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020u0t\u0012\b\u0012\u00060vR\u00020\u00030=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010?R8\u0010x\u001a\u001f\u0012\u0013\u0012\u00110,¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u0006\u0018\u00010yX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R<\u0010\u0081\u0001\u001a \u0012\u0014\u0012\u00120,¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010yX\u0080\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0083\u0001\u0010~\"\u0006\b\u0084\u0001\u0010\u0080\u0001R#\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0086\u00010=X\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010?R\u000f\u0010¿\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020,0\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Ï\u0001\u001a\u0004\u0018\u00010u8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0019\u0010\u0085\u0002\u001a\u0004\u0018\u00010,8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u001e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020,0\u0089\u0002X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0019\u0010\u008c\u0002\u001a\u0004\u0018\u00010,8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010\u0087\u0002¨\u0006\u008f\u0002"}, d2 = {"Landroidx/navigation/internal/NavControllerImpl;", "", "navController", "Landroidx/navigation/NavController;", "updateOnBackPressedCallbackEnabledCallback", "Lkotlin/Function0;", "", "<init>", "(Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function0;)V", "getNavController", "()Landroidx/navigation/NavController;", "getUpdateOnBackPressedCallbackEnabledCallback", "()Lkotlin/jvm/functions/Function0;", "setUpdateOnBackPressedCallbackEnabledCallback", "(Lkotlin/jvm/functions/Function0;)V", "navContext", "Landroidx/navigation/internal/NavContext;", "getNavContext", "()Landroidx/navigation/internal/NavContext;", "_graph", "Landroidx/navigation/NavGraph;", "get_graph$navigation_runtime_release", "()Landroidx/navigation/NavGraph;", "set_graph$navigation_runtime_release", "(Landroidx/navigation/NavGraph;)V", "graph", "getGraph$navigation_runtime_release", "setGraph$navigation_runtime_release", "navigatorStateToRestore", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "getNavigatorStateToRestore$navigation_runtime_release", "()Landroid/os/Bundle;", "setNavigatorStateToRestore$navigation_runtime_release", "(Landroid/os/Bundle;)V", "backStackToRestore", "", "getBackStackToRestore$navigation_runtime_release", "()[Landroid/os/Bundle;", "setBackStackToRestore$navigation_runtime_release", "([Landroid/os/Bundle;)V", "[Landroid/os/Bundle;", "backQueue", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntry;", "getBackQueue$navigation_runtime_release", "()Lkotlin/collections/ArrayDeque;", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "get_currentBackStack$navigation_runtime_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack$navigation_runtime_release", "()Lkotlinx/coroutines/flow/StateFlow;", "_visibleEntries", "get_visibleEntries$navigation_runtime_release", "visibleEntries", "getVisibleEntries$navigation_runtime_release", "childToParentEntries", "", "getChildToParentEntries$navigation_runtime_release", "()Ljava/util/Map;", "parentToChildCount", "Landroidx/navigation/internal/AtomicInt;", "getParentToChildCount$navigation_runtime_release", "linkChildToParent", "child", "parent", "linkChildToParent$navigation_runtime_release", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "backStackMap", "", "", "getBackStackMap$navigation_runtime_release", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "getBackStackStates$navigation_runtime_release", "value", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner$navigation_runtime_release", "()Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "getViewModel$navigation_runtime_release", "()Landroidx/navigation/NavControllerViewModel;", "setViewModel$navigation_runtime_release", "(Landroidx/navigation/NavControllerViewModel;)V", "onDestinationChangedListeners", "", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "getOnDestinationChangedListeners$navigation_runtime_release", "()Ljava/util/List;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "getLifecycleObserver$navigation_runtime_release", "()Landroidx/lifecycle/LifecycleObserver;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "get_navigatorProvider$navigation_runtime_release", "()Landroidx/navigation/NavigatorProvider;", "set_navigatorProvider$navigation_runtime_release", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorProvider", "getNavigatorProvider$navigation_runtime_release", "setNavigatorProvider$navigation_runtime_release", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "getNavigatorState$navigation_runtime_release", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "getAddToBackStackHandler$navigation_runtime_release", "()Lkotlin/jvm/functions/Function1;", "setAddToBackStackHandler$navigation_runtime_release", "(Lkotlin/jvm/functions/Function1;)V", "popFromBackStackHandler", "popUpTo", "getPopFromBackStackHandler$navigation_runtime_release", "setPopFromBackStackHandler$navigation_runtime_release", "entrySavedState", "", "getEntrySavedState$navigation_runtime_release", "navigateInternal", "navigator", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "handler", "navigateInternal$navigation_runtime_release", "popBackStackInternal", "saveState", "popBackStackInternal$navigation_runtime_release", Constants.PUSH, RemoteConfigConstants.ResponseFieldKey.STATE, "push$navigation_runtime_release", "createBackStackEntry", FirebaseAnalytics.Param.DESTINATION, "arguments", "createBackStackEntry$navigation_runtime_release", "pop", "superCallback", "pop$navigation_runtime_release", "markTransitionComplete", "entry", "markTransitionComplete$navigation_runtime_release", "prepareForTransition", "prepareForTransition$navigation_runtime_release", "addOnDestinationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnDestinationChangedListener$navigation_runtime_release", "removeOnDestinationChangedListener", "removeOnDestinationChangedListener$navigation_runtime_release", "popBackStack", "popBackStack$navigation_runtime_release", "destinationId", "inclusive", "route", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;ZZ)Z", "executePopOperations", "popOperations", "foundDestination", "executePopOperations$navigation_runtime_release", "popBackStackFromNavigator", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "popEntryFromBackStack", "savedState", "popEntryFromBackStack$navigation_runtime_release", "clearBackStack", "clearBackStack$navigation_runtime_release", "(Ljava/lang/Object;)Z", "clearBackStackInternal", "clearBackStackInternal$navigation_runtime_release", "dispatchReentrantCount", "backStackEntriesToDispatch", "dispatchOnDestinationChanged", "dispatchOnDestinationChanged$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "setGraph", "startDestinationArgs", "onGraphCreated", "onGraphCreated$navigation_runtime_release", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "findInvalidDestinationDisplayNameInDeepLink$navigation_runtime_release", "currentDestination", "getCurrentDestination$navigation_runtime_release", "()Landroidx/navigation/NavDestination;", "findDestination", "matchingDest", "findDestination$navigation_runtime_release", "findDestinationComprehensive", "searchChildren", "findDestinationComprehensive$navigation_runtime_release", "getTopGraph", "getTopGraph$navigation_runtime_release", "generateRouteFilled", "generateRouteFilled$navigation_runtime_release", "(Ljava/lang/Object;)Ljava/lang/String;", "navigate", "Landroid/net/Uri;", "Landroidx/navigation/NavUri;", "navigate$navigation_runtime_release", "request", "Landroidx/navigation/NavDeepLinkRequest;", "node", "args", "launchSingleTopInternal", "restoreStateInternal", "id", "executeRestoreState", "instantiateBackStack", "backStackState", "addEntryToBackStack", "finalArgs", "restoredEntries", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "saveState$navigation_runtime_release", "restoreState", "navState", "restoreState$navigation_runtime_release", "setLifecycleOwner", "owner", "setLifecycleOwner$navigation_runtime_release", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "setViewModelStore$navigation_runtime_release", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "getViewModelStoreOwner$navigation_runtime_release", "getBackStackEntry", "getBackStackEntry$navigation_runtime_release", "(Ljava/lang/Object;)Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getCurrentBackStackEntry$navigation_runtime_release", "()Landroidx/navigation/NavBackStackEntry;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_currentBackStackEntryFlow$navigation_runtime_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "previousBackStackEntry", "getPreviousBackStackEntry$navigation_runtime_release", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavControllerImpl {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    public static final String TAG = "NavController";
    private final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Bundle[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private int dispatchReentrantCount;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final NavController navController;
    private final Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final List<NavController.OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInt> parentToChildCount;
    private Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    private Function0<Unit> updateOnBackPressedCallbackEnabledCallback;
    private NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    public NavControllerImpl(NavController navController, Function0<Unit> updateOnBackPressedCallbackEnabledCallback) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(updateOnBackPressedCallbackEnabledCallback, "updateOnBackPressedCallbackEnabledCallback");
        this.navController = navController;
        this.updateOnBackPressedCallbackEnabledCallback = updateOnBackPressedCallbackEnabledCallback;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._currentBackStack = MutableStateFlow;
        this.currentBackStack = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new ArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavControllerImpl.lifecycleObserver$lambda$1(NavControllerImpl.this, lifecycleOwner, event);
            }
        };
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        this.backStackEntriesToDispatch = new ArrayList();
        this._currentBackStackEntryFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
    }

    public final NavController getNavController() {
        return this.navController;
    }

    public final Function0<Unit> getUpdateOnBackPressedCallbackEnabledCallback() {
        return this.updateOnBackPressedCallbackEnabledCallback;
    }

    public final void setUpdateOnBackPressedCallbackEnabledCallback(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.updateOnBackPressedCallbackEnabledCallback = function0;
    }

    public final NavContext getNavContext() {
        return this.navController.getNavContext$navigation_runtime_release();
    }

    public final NavGraph get_graph$navigation_runtime_release() {
        return this._graph;
    }

    public final void set_graph$navigation_runtime_release(NavGraph navGraph) {
        this._graph = navGraph;
    }

    public final NavGraph getGraph$navigation_runtime_release() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        }
        Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final void setGraph$navigation_runtime_release(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        setGraph$navigation_runtime_release(graph, null);
    }

    public final Bundle getNavigatorStateToRestore$navigation_runtime_release() {
        return this.navigatorStateToRestore;
    }

    public final void setNavigatorStateToRestore$navigation_runtime_release(Bundle bundle) {
        this.navigatorStateToRestore = bundle;
    }

    public final Bundle[] getBackStackToRestore$navigation_runtime_release() {
        return this.backStackToRestore;
    }

    public final void setBackStackToRestore$navigation_runtime_release(Bundle[] bundleArr) {
        this.backStackToRestore = bundleArr;
    }

    public final ArrayDeque<NavBackStackEntry> getBackQueue$navigation_runtime_release() {
        return this.backQueue;
    }

    public final MutableStateFlow<List<NavBackStackEntry>> get_currentBackStack$navigation_runtime_release() {
        return this._currentBackStack;
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack$navigation_runtime_release() {
        return this.currentBackStack;
    }

    public final MutableStateFlow<List<NavBackStackEntry>> get_visibleEntries$navigation_runtime_release() {
        return this._visibleEntries;
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries$navigation_runtime_release() {
        return this.visibleEntries;
    }

    public final Map<NavBackStackEntry, NavBackStackEntry> getChildToParentEntries$navigation_runtime_release() {
        return this.childToParentEntries;
    }

    public final Map<NavBackStackEntry, AtomicInt> getParentToChildCount$navigation_runtime_release() {
        return this.parentToChildCount;
    }

    public final void linkChildToParent$navigation_runtime_release(NavBackStackEntry child, NavBackStackEntry parent) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInt(0));
        }
        AtomicInt atomicInt = this.parentToChildCount.get(parent);
        Intrinsics.checkNotNull(atomicInt);
        atomicInt.incrementAndGet$navigation_runtime_release();
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(child);
        if (remove == null) {
            return null;
        }
        AtomicInt atomicInt = this.parentToChildCount.get(remove);
        Integer valueOf = atomicInt != null ? Integer.valueOf(atomicInt.decrementAndGet$navigation_runtime_release()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final Map<Integer, String> getBackStackMap$navigation_runtime_release() {
        return this.backStackMap;
    }

    public final Map<String, ArrayDeque<NavBackStackEntryState>> getBackStackStates$navigation_runtime_release() {
        return this.backStackStates;
    }

    public final LifecycleOwner getLifecycleOwner$navigation_runtime_release() {
        return this.lifecycleOwner;
    }

    public final NavControllerViewModel getViewModel$navigation_runtime_release() {
        return this.viewModel;
    }

    public final void setViewModel$navigation_runtime_release(NavControllerViewModel navControllerViewModel) {
        this.viewModel = navControllerViewModel;
    }

    public final List<NavController.OnDestinationChangedListener> getOnDestinationChangedListeners$navigation_runtime_release() {
        return this.onDestinationChangedListeners;
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    public final LifecycleObserver getLifecycleObserver$navigation_runtime_release() {
        return this.lifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$1(NavControllerImpl navControllerImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        navControllerImpl.hostLifecycleState = event.getTargetState();
        if (navControllerImpl._graph != null) {
            for (NavBackStackEntry navBackStackEntry : CollectionsKt.toMutableList((Collection) navControllerImpl.backQueue)) {
                navBackStackEntry.handleLifecycleEvent(event);
            }
        }
    }

    public final NavigatorProvider get_navigatorProvider$navigation_runtime_release() {
        return this._navigatorProvider;
    }

    public final void set_navigatorProvider$navigation_runtime_release(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<set-?>");
        this._navigatorProvider = navigatorProvider;
    }

    public final NavigatorProvider getNavigatorProvider$navigation_runtime_release() {
        return this._navigatorProvider;
    }

    public final void setNavigatorProvider$navigation_runtime_release(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
        }
        this._navigatorProvider = navigatorProvider;
    }

    public final Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> getNavigatorState$navigation_runtime_release() {
        return this.navigatorState;
    }

    public final Function1<NavBackStackEntry, Unit> getAddToBackStackHandler$navigation_runtime_release() {
        return this.addToBackStackHandler;
    }

    public final void setAddToBackStackHandler$navigation_runtime_release(Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
    }

    public final Function1<NavBackStackEntry, Unit> getPopFromBackStackHandler$navigation_runtime_release() {
        return this.popFromBackStackHandler;
    }

    public final void setPopFromBackStackHandler$navigation_runtime_release(Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
    }

    public final Map<NavBackStackEntry, Boolean> getEntrySavedState$navigation_runtime_release() {
        return this.entrySavedState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateInternal$lambda$3(NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void navigateInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1, int i, Object obj) {
        Function1 function12 = function1;
        if ((i & 16) != 0) {
            function12 = new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit navigateInternal$lambda$3;
                    navigateInternal$lambda$3 = NavControllerImpl.navigateInternal$lambda$3((NavBackStackEntry) obj2);
                    return navigateInternal$lambda$3;
                }
            };
        }
        navControllerImpl.navigateInternal$navigation_runtime_release(navigator, list, navOptions, extras, function12);
    }

    public final void navigateInternal$navigation_runtime_release(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.addToBackStackHandler = handler;
        navigator.navigate(entries, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit popBackStackInternal$lambda$4(NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit popBackStackInternal$lambda$4;
                    popBackStackInternal$lambda$4 = NavControllerImpl.popBackStackInternal$lambda$4((NavBackStackEntry) obj2);
                    return popBackStackInternal$lambda$4;
                }
            };
        }
        navControllerImpl.popBackStackInternal$navigation_runtime_release(navigator, navBackStackEntry, z, function1);
    }

    public final void popBackStackInternal$navigation_runtime_release(Navigator<? extends NavDestination> navigator, NavBackStackEntry popUpTo, boolean z, Function1<? super NavBackStackEntry, Unit> handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.popFromBackStackHandler = handler;
        navigator.popBackStack(popUpTo, z);
        this.popFromBackStackHandler = null;
    }

    public final void push$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        Navigator navigator = this._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
        if (Intrinsics.areEqual(navigator, state.getNavigator())) {
            Function1<? super NavBackStackEntry, Unit> function1 = this.addToBackStackHandler;
            if (function1 != null) {
                function1.invoke(backStackEntry);
                state.addInternal(backStackEntry);
                return;
            }
            Log.Companion.i(TAG, "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
            return;
        }
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(navigator);
        if (navControllerNavigatorState == null) {
            throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
        navControllerNavigatorState.push(backStackEntry);
    }

    public final NavBackStackEntry createBackStackEntry$navigation_runtime_release(NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, getNavContext(), destination, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    }

    public final void pop$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry popUpTo, boolean z, final Function0<Unit> superCallback) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        Navigator navigator = this._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
        this.entrySavedState.put(popUpTo, Boolean.valueOf(z));
        if (Intrinsics.areEqual(navigator, state.getNavigator())) {
            Function1<? super NavBackStackEntry, Unit> function1 = this.popFromBackStackHandler;
            if (function1 != null) {
                function1.invoke(popUpTo);
                superCallback.invoke();
                return;
            }
            popBackStackFromNavigator$navigation_runtime_release(popUpTo, new Function0() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit pop$lambda$6;
                    pop$lambda$6 = NavControllerImpl.pop$lambda$6(Function0.this);
                    return pop$lambda$6;
                }
            });
            return;
        }
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(navigator);
        Intrinsics.checkNotNull(navControllerNavigatorState);
        navControllerNavigatorState.pop(popUpTo, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pop$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void markTransitionComplete$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry entry, Function0<Unit> superCallback) {
        NavControllerViewModel navControllerViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        boolean areEqual = Intrinsics.areEqual((Object) this.entrySavedState.get(entry), (Object) true);
        superCallback.invoke();
        this.entrySavedState.remove(entry);
        if (!this.backQueue.contains(entry)) {
            unlinkChildFromParent$navigation_runtime_release(entry);
            if (entry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
            if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
                for (NavBackStackEntry navBackStackEntry : arrayDeque) {
                    if (Intrinsics.areEqual(navBackStackEntry.getId(), entry.getId())) {
                        break;
                    }
                }
            }
            if (!areEqual && (navControllerViewModel = this.viewModel) != null) {
                navControllerViewModel.clear(entry.getId());
            }
            updateBackStackLifecycle$navigation_runtime_release();
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        } else if (!state.isNavigating()) {
            updateBackStackLifecycle$navigation_runtime_release();
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
    }

    public final void prepareForTransition$navigation_runtime_release(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (this.backQueue.contains(entry)) {
            entry.setMaxLifecycle(Lifecycle.State.STARTED);
            return;
        }
        throw new IllegalStateException("Cannot transition entry that is not in the back stack");
    }

    public final void addOnDestinationChangedListener$navigation_runtime_release(NavController.OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry last = this.backQueue.last();
        listener.onDestinationChanged(this.navController, last.getDestination(), last.getArguments());
    }

    public final void removeOnDestinationChangedListener$navigation_runtime_release(NavController.OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    public final boolean popBackStack$navigation_runtime_release() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination$navigation_runtime_release = getCurrentDestination$navigation_runtime_release();
        Intrinsics.checkNotNull(currentDestination$navigation_runtime_release);
        return popBackStack$navigation_runtime_release(currentDestination$navigation_runtime_release.getId(), true);
    }

    public final boolean popBackStack$navigation_runtime_release(int i, boolean z) {
        return popBackStack$navigation_runtime_release(i, z, false);
    }

    public final boolean popBackStack$navigation_runtime_release(int i, boolean z, boolean z2) {
        return popBackStackInternal$navigation_runtime_release(i, z, z2) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean popBackStack$navigation_runtime_release(String route, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release(route, z, z2) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final <T> boolean popBackStack$navigation_runtime_release(KClass<T> route, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(route, "route");
        int generateHashCode = RouteSerializerKt.generateHashCode(SerializersKt.serializer(route));
        if (findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), generateHashCode, true, null, 8, null) == null) {
            throw new IllegalArgumentException(("Destination with route " + route.getSimpleName() + " cannot be found in navigation graph " + getGraph$navigation_runtime_release()).toString());
        }
        return popBackStack$navigation_runtime_release(generateHashCode, z, z2);
    }

    public final <T> boolean popBackStack$navigation_runtime_release(T route, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release((NavControllerImpl) route, z, z2) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public static /* synthetic */ boolean popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navControllerImpl.popBackStackInternal$navigation_runtime_release(i, z, z2);
    }

    public final boolean popBackStackInternal$navigation_runtime_release(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination.getNavigatorName());
            if (z || navDestination.getId() != i) {
                arrayList.add(navigator);
            }
            if (navDestination.getId() == i) {
                break;
            }
        }
        if (navDestination == null) {
            Log.Companion.i(TAG, "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(getNavContext(), i) + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations$navigation_runtime_release(arrayList, navDestination, z, z2);
    }

    public static /* synthetic */ boolean popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navControllerImpl.popBackStackInternal$navigation_runtime_release((NavControllerImpl) obj, z, z2);
    }

    public final <T> boolean popBackStackInternal$navigation_runtime_release(T route, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route), z, z2);
    }

    public final boolean popBackStackInternal$navigation_runtime_release(String route, boolean z, boolean z2) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            boolean hasRoute = navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments());
            if (z || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
                continue;
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        NavDestination destination = navBackStackEntry3 != null ? navBackStackEntry3.getDestination() : null;
        if (destination == null) {
            Log.Companion.i(TAG, "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations$navigation_runtime_release(arrayList, destination, z, z2);
    }

    public final boolean executePopOperations$navigation_runtime_release(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean z, boolean z2) {
        final NavControllerImpl navControllerImpl;
        final boolean z3;
        Intrinsics.checkNotNullParameter(popOperations, "popOperations");
        Intrinsics.checkNotNullParameter(foundDestination, "foundDestination");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                navControllerImpl = this;
                z3 = z2;
                break;
            }
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            navControllerImpl = this;
            z3 = z2;
            popBackStackInternal$navigation_runtime_release((Navigator) it.next(), this.backQueue.last(), z3, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit executePopOperations$lambda$10;
                    executePopOperations$lambda$10 = NavControllerImpl.executePopOperations$lambda$10(Ref.BooleanRef.this, booleanRef, navControllerImpl, z3, arrayDeque, (NavBackStackEntry) obj);
                    return executePopOperations$lambda$10;
                }
            });
            if (!booleanRef2.element) {
                break;
            }
            z2 = z3;
        }
        if (z3) {
            if (!z) {
                for (NavDestination navDestination : SequencesKt.takeWhile(SequencesKt.generateSequence(foundDestination, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        NavDestination executePopOperations$lambda$11;
                        executePopOperations$lambda$11 = NavControllerImpl.executePopOperations$lambda$11((NavDestination) obj);
                        return executePopOperations$lambda$11;
                    }
                }), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean executePopOperations$lambda$12;
                        executePopOperations$lambda$12 = NavControllerImpl.executePopOperations$lambda$12(NavControllerImpl.this, (NavDestination) obj);
                        return Boolean.valueOf(executePopOperations$lambda$12);
                    }
                })) {
                    Map<Integer, String> map = navControllerImpl.backStackMap;
                    Integer valueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState firstOrNull = arrayDeque.firstOrNull();
                    map.put(valueOf, firstOrNull != null ? firstOrNull.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState first = arrayDeque.first();
                for (NavDestination navDestination2 : SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination$navigation_runtime_release$default(this, first.getDestinationId(), null, 2, null), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        NavDestination executePopOperations$lambda$14;
                        executePopOperations$lambda$14 = NavControllerImpl.executePopOperations$lambda$14((NavDestination) obj);
                        return executePopOperations$lambda$14;
                    }
                }), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean executePopOperations$lambda$15;
                        executePopOperations$lambda$15 = NavControllerImpl.executePopOperations$lambda$15(NavControllerImpl.this, (NavDestination) obj);
                        return Boolean.valueOf(executePopOperations$lambda$15);
                    }
                })) {
                    navControllerImpl.backStackMap.put(Integer.valueOf(navDestination2.getId()), first.getId());
                }
                if (navControllerImpl.backStackMap.values().contains(first.getId())) {
                    navControllerImpl.backStackStates.put(first.getId(), arrayDeque);
                }
            }
        }
        navControllerImpl.updateOnBackPressedCallbackEnabledCallback.invoke();
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executePopOperations$lambda$10(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavControllerImpl navControllerImpl, boolean z, ArrayDeque arrayDeque, NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.element = true;
        booleanRef2.element = true;
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(entry, z, arrayDeque);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDestination executePopOperations$lambda$11(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
            return null;
        }
        return destination.getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean executePopOperations$lambda$12(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.backStackMap.containsKey(Integer.valueOf(destination.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDestination executePopOperations$lambda$14(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
            return null;
        }
        return destination.getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean executePopOperations$lambda$15(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.backStackMap.containsKey(Integer.valueOf(destination.getId()));
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        int indexOf = this.backQueue.indexOf(popUpTo);
        if (indexOf < 0) {
            Log.Companion.i(TAG, "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal$navigation_runtime_release(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$navigation_runtime_release$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        dispatchOnDestinationChanged$navigation_runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popEntryFromBackStack$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(navBackStackEntry, z, arrayDeque);
    }

    public final void popEntryFromBackStack$navigation_runtime_release(NavBackStackEntry popUpTo, boolean z, ArrayDeque<NavBackStackEntryState> savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        NavBackStackEntry last = this.backQueue.last();
        if (!Intrinsics.areEqual(last, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + ')').toString());
        }
        CollectionsKt.removeLast(this.backQueue);
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider$navigation_runtime_release().getNavigator(last.getDestination().getNavigatorName()));
        boolean z2 = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) && !this.parentToChildCount.containsKey(last)) {
            z2 = false;
        }
        if (last.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            if (z) {
                last.setMaxLifecycle(Lifecycle.State.CREATED);
                savedState.addFirst(new NavBackStackEntryState(last));
            }
            if (!z2) {
                last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(last);
            } else {
                last.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        if (z || z2 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(last.getId());
    }

    public final boolean clearBackStack$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStackInternal$navigation_runtime_release(route) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean clearBackStack$navigation_runtime_release(int i) {
        return clearBackStackInternal$navigation_runtime_release(i) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final <T> boolean clearBackStack$navigation_runtime_release(KClass<T> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStack$navigation_runtime_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)));
    }

    public final <T> boolean clearBackStack$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStackInternal$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route)) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean clearBackStackInternal$navigation_runtime_release(int i) {
        for (NavController.NavControllerNavigatorState navControllerNavigatorState : this.navigatorState.values()) {
            navControllerNavigatorState.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i, null, NavOptionsBuilderKt.navOptions(new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit clearBackStackInternal$lambda$19;
                clearBackStackInternal$lambda$19 = NavControllerImpl.clearBackStackInternal$lambda$19((NavOptionsBuilder) obj);
                return clearBackStackInternal$lambda$19;
            }
        }), null);
        for (NavController.NavControllerNavigatorState navControllerNavigatorState2 : this.navigatorState.values()) {
            navControllerNavigatorState2.setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal$navigation_runtime_release(i, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearBackStackInternal$lambda$19(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.setRestoreState(true);
        return Unit.INSTANCE;
    }

    public final boolean clearBackStackInternal$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        for (NavController.NavControllerNavigatorState navControllerNavigatorState : this.navigatorState.values()) {
            navControllerNavigatorState.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(route);
        for (NavController.NavControllerNavigatorState navControllerNavigatorState2 : this.navigatorState.values()) {
            navControllerNavigatorState2.setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal$navigation_runtime_release(route, true, false);
    }

    public final boolean dispatchOnDestinationChanged$navigation_runtime_release() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$navigation_runtime_release$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                for (NavController.OnDestinationChangedListener onDestinationChangedListener : this.onDestinationChangedListeners) {
                    onDestinationChangedListener.onDestinationChanged(this.navController, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        return lastOrNull != null;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInt atomicInt;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backQueue);
        if (mutableList.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) CollectionsKt.last((List<? extends Object>) mutableList)).getDestination();
        List mutableListOf = CollectionsKt.mutableListOf(destination);
        if (destination instanceof SupportingPane) {
            boolean z = destination instanceof FloatingWindow;
            for (NavBackStackEntry navBackStackEntry : CollectionsKt.drop(CollectionsKt.reversed(mutableList), 1)) {
                NavDestination destination2 = navBackStackEntry.getDestination();
                if (z && !(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
                mutableListOf.add(destination2);
                if (!(destination2 instanceof SupportingPane) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionsKt.last((List<? extends Object>) mutableListOf) instanceof FloatingWindow) {
            for (NavBackStackEntry navBackStackEntry2 : CollectionsKt.reversed(mutableList)) {
                NavDestination destination3 = navBackStackEntry2.getDestination();
                arrayList.add(destination3);
                if (!(destination3 instanceof FloatingWindow) && !(destination3 instanceof SupportingPane) && !(destination3 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry3 : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State maxLifecycle = navBackStackEntry3.getMaxLifecycle();
            NavDestination destination4 = navBackStackEntry3.getDestination();
            NavDestination navDestination = (NavDestination) CollectionsKt.firstOrNull((List<? extends Object>) mutableListOf);
            if (navDestination != null && navDestination.getId() == destination4.getId()) {
                if (maxLifecycle != Lifecycle.State.RESUMED) {
                    NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider$navigation_runtime_release().getNavigator(navBackStackEntry3.getDestination().getNavigatorName()));
                    if (!Intrinsics.areEqual((Object) ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry3))), (Object) true) && ((atomicInt = this.parentToChildCount.get(navBackStackEntry3)) == null || atomicInt.get$navigation_runtime_release() != 0)) {
                        hashMap.put(navBackStackEntry3, Lifecycle.State.RESUMED);
                    } else {
                        hashMap.put(navBackStackEntry3, Lifecycle.State.STARTED);
                    }
                }
                NavDestination navDestination2 = (NavDestination) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                if (navDestination2 != null && navDestination2.getId() == destination4.getId()) {
                    CollectionsKt.removeFirst(arrayList);
                }
                CollectionsKt.removeFirst(mutableListOf);
                NavGraph parent = destination4.getParent();
                if (parent != null) {
                    mutableListOf.add(parent);
                }
            } else if (!arrayList.isEmpty() && destination4.getId() == ((NavDestination) CollectionsKt.first((List<? extends Object>) arrayList)).getId()) {
                NavDestination navDestination3 = (NavDestination) CollectionsKt.removeFirst(arrayList);
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry3.setMaxLifecycle(Lifecycle.State.STARTED);
                } else if (maxLifecycle != Lifecycle.State.STARTED) {
                    hashMap.put(navBackStackEntry3, Lifecycle.State.STARTED);
                }
                NavGraph parent2 = navDestination3.getParent();
                if (parent2 != null && !arrayList.contains(parent2)) {
                    arrayList.add(parent2);
                }
            } else {
                navBackStackEntry3.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        for (NavBackStackEntry navBackStackEntry4 : mutableList) {
            Lifecycle.State state = (Lifecycle.State) hashMap.get(navBackStackEntry4);
            if (state != null) {
                navBackStackEntry4.setMaxLifecycle(state);
            } else {
                navBackStackEntry4.updateState();
            }
        }
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        for (NavController.NavControllerNavigatorState navControllerNavigatorState : this.navigatorState.values()) {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : navControllerNavigatorState.getTransitionsInProgress().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList3.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : this.backQueue) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList5.add(navBackStackEntry2);
            }
        }
        CollectionsKt.addAll(arrayList4, arrayList5);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList6.add(obj2);
            }
        }
        return arrayList6;
    }

    public final void setGraph$navigation_runtime_release(NavGraph graph, Bundle bundle) {
        NavControllerImpl navControllerImpl;
        Intrinsics.checkNotNullParameter(graph, "graph");
        if (!this.backQueue.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.".toString());
        }
        if (!Intrinsics.areEqual(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNull(num);
                    clearBackStackInternal$navigation_runtime_release(num.intValue());
                }
                navControllerImpl = this;
                popBackStackInternal$navigation_runtime_release$default(navControllerImpl, navGraph.getId(), true, false, 4, (Object) null);
            } else {
                navControllerImpl = this;
            }
            navControllerImpl._graph = graph;
            onGraphCreated$navigation_runtime_release(bundle);
            return;
        }
        int size = graph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            int keyAt = navGraph2.getNodes().keyAt(i);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(keyAt, graph.getNodes().valueAt(i));
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            NavDestination navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
            for (NavDestination navDestination2 : CollectionsKt.asReversed(SequencesKt.toList(NavDestination.Companion.getHierarchy(navBackStackEntry.getDestination())))) {
                navDestination = navDestination;
                if (!Intrinsics.areEqual(navDestination2, this._graph) || !Intrinsics.areEqual(navDestination, graph)) {
                    if (navDestination instanceof NavGraph) {
                        navDestination = ((NavGraph) navDestination).findNode(navDestination2.getId());
                        Intrinsics.checkNotNull(navDestination);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestination);
        }
    }

    public final void onGraphCreated$navigation_runtime_release(Bundle bundle) {
        Bundle bundle2 = this.navigatorStateToRestore;
        if (bundle2 != null) {
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle2);
            if (SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_NAVIGATOR_STATE_NAMES)) {
                for (String str : SavedStateReader.m7654getStringListimpl(m7580constructorimpl, KEY_NAVIGATOR_STATE_NAMES)) {
                    Navigator navigator = this._navigatorProvider.getNavigator(str);
                    if (SavedStateReader.m7581containsimpl(m7580constructorimpl, str)) {
                        navigator.onRestoreState(SavedStateReader.m7637getSavedStateimpl(m7580constructorimpl, str));
                    }
                }
            }
        }
        Bundle[] bundleArr = this.backStackToRestore;
        if (bundleArr != null) {
            for (Bundle bundle3 : bundleArr) {
                NavBackStackEntryState navBackStackEntryState = new NavBackStackEntryState(bundle3);
                NavDestination findDestination$navigation_runtime_release$default = findDestination$navigation_runtime_release$default(this, navBackStackEntryState.getDestinationId(), null, 2, null);
                if (findDestination$navigation_runtime_release$default == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(getNavContext(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination$navigation_runtime_release());
                }
                NavBackStackEntry instantiate = navBackStackEntryState.instantiate(getNavContext(), findDestination$navigation_runtime_release$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(findDestination$navigation_runtime_release$default.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> map = this.navigatorState;
                NavController.NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = this.navController.createNavControllerNavigatorState$navigation_runtime_release(navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.add(instantiate);
                navControllerNavigatorState.addInternal(instantiate);
                NavGraph parent = instantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent$navigation_runtime_release(instantiate, getBackStackEntry$navigation_runtime_release(parent.getId()));
                }
            }
            this.updateOnBackPressedCallbackEnabledCallback.invoke();
            this.backStackToRestore = null;
        }
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : this._navigatorProvider.getNavigators().values()) {
            if (!((Navigator) obj).isAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> map2 = this.navigatorState;
            NavController.NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = this.navController.createNavControllerNavigatorState$navigation_runtime_release(navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph != null && this.backQueue.isEmpty()) {
            if (this.navController.checkDeepLinkHandled$navigation_runtime_release()) {
                return;
            }
            NavGraph navGraph = this._graph;
            Intrinsics.checkNotNull(navGraph);
            navigate$navigation_runtime_release(navGraph, bundle, null, null);
            return;
        }
        dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final String findInvalidDestinationDisplayNameInDeepLink$navigation_runtime_release(int[] deepLink) {
        NavGraph findNode;
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            int i2 = deepLink[i];
            if (i == 0) {
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                findNode = navGraph3.getId() == i2 ? this._graph : null;
            } else {
                Intrinsics.checkNotNull(navGraph2);
                findNode = navGraph2.findNode(i2);
            }
            if (findNode == null) {
                return NavDestination.Companion.getDisplayName(getNavContext(), i2);
            }
            if (i != deepLink.length - 1 && (findNode instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public final NavDestination getCurrentDestination$navigation_runtime_release() {
        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
        if (currentBackStackEntry$navigation_runtime_release != null) {
            return currentBackStackEntry$navigation_runtime_release.getDestination();
        }
        return null;
    }

    public static /* synthetic */ NavDestination findDestination$navigation_runtime_release$default(NavControllerImpl navControllerImpl, int i, NavDestination navDestination, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            navDestination = null;
        }
        return navControllerImpl.findDestination$navigation_runtime_release(i, navDestination);
    }

    public final NavDestination findDestination$navigation_runtime_release(int i, NavDestination navDestination) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (navGraph2.getId() == i) {
            if (navDestination != null) {
                if (Intrinsics.areEqual(this._graph, navDestination) && navDestination.getParent() == null) {
                    return this._graph;
                }
            } else {
                return this._graph;
            }
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navGraph = lastOrNull.getDestination()) == null) {
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph = navGraph3;
        }
        return findDestinationComprehensive$navigation_runtime_release(navGraph, i, false, navDestination);
    }

    public static /* synthetic */ NavDestination findDestinationComprehensive$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavDestination navDestination, int i, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            navDestination2 = null;
        }
        return navControllerImpl.findDestinationComprehensive$navigation_runtime_release(navDestination, i, z, navDestination2);
    }

    public final NavDestination findDestinationComprehensive$navigation_runtime_release(NavDestination destination, int i, boolean z, NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.getId() == i && (navDestination == null || (Intrinsics.areEqual(destination, navDestination) && Intrinsics.areEqual(destination.getParent(), navDestination.getParent())))) {
            return destination;
        }
        NavGraph navGraph = destination instanceof NavGraph ? (NavGraph) destination : null;
        if (navGraph == null) {
            navGraph = destination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNodeComprehensive(i, navGraph, z, navDestination);
    }

    public final NavDestination findDestination$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (!Intrinsics.areEqual(navGraph.getRoute(), route)) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            if (navGraph2.matchRoute(route) == null) {
                return getTopGraph$navigation_runtime_release().findNode(route);
            }
        }
        return this._graph;
    }

    public final NavGraph getTopGraph$navigation_runtime_release() {
        NavGraph navGraph;
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navGraph = lastOrNull.getDestination()) == null) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            navGraph = navGraph2;
        }
        NavGraph navGraph3 = navGraph instanceof NavGraph ? (NavGraph) navGraph : null;
        if (navGraph3 == null) {
            NavGraph parent = navGraph.getParent();
            Intrinsics.checkNotNull(parent);
            return parent;
        }
        return navGraph3;
    }

    public final <T> String generateRouteFilled$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination findDestinationComprehensive$navigation_runtime_release$default = findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()))), true, null, 8, null);
        if (findDestinationComprehensive$navigation_runtime_release$default == null) {
            throw new IllegalArgumentException(("Destination with route " + Reflection.getOrCreateKotlinClass(route.getClass()).getSimpleName() + " cannot be found in navigation graph " + this._graph).toString());
        }
        Map<String, NavArgument> arguments = findDestinationComprehensive$navigation_runtime_release$default.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(route, linkedHashMap);
    }

    public final void navigate$navigation_runtime_release(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null));
    }

    public final void navigate$navigation_runtime_release(Uri deepLink, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions, (Navigator.Extras) null);
    }

    public final void navigate$navigation_runtime_release(Uri deepLink, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions, extras);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate$navigation_runtime_release(request, (NavOptions) null);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate$navigation_runtime_release(request, navOptions, (Navigator.Extras) null);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras extras) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this.navController + '.').toString());
        }
        NavGraph topGraph$navigation_runtime_release = getTopGraph$navigation_runtime_release();
        NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(request, true, true, topGraph$navigation_runtime_release);
        if (matchDeepLinkComprehensive != null) {
            Bundle addInDefaultArgs = matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
            if (addInDefaultArgs == null) {
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
                addInDefaultArgs = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.m7666constructorimpl(addInDefaultArgs);
            }
            NavDestination destination = matchDeepLinkComprehensive.getDestination();
            this.navController.writeIntent$navigation_runtime_release(request, addInDefaultArgs);
            navigate$navigation_runtime_release(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012c A[LOOP:1: B:40:0x0126->B:42:0x012c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void navigate$navigation_runtime_release(final NavDestination node, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        boolean z;
        boolean z2;
        boolean popBackStackInternal$navigation_runtime_release;
        Intrinsics.checkNotNullParameter(node, "node");
        for (NavController.NavControllerNavigatorState navControllerNavigatorState : this.navigatorState.values()) {
            navControllerNavigatorState.setNavigating(true);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (navOptions != null) {
            if (navOptions.getPopUpToRoute() != null) {
                String popUpToRoute = navOptions.getPopUpToRoute();
                Intrinsics.checkNotNull(popUpToRoute);
                popBackStackInternal$navigation_runtime_release = popBackStackInternal$navigation_runtime_release(popUpToRoute, navOptions.isPopUpToInclusive(), navOptions.shouldPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteClass() != null) {
                KClass<?> popUpToRouteClass = navOptions.getPopUpToRouteClass();
                Intrinsics.checkNotNull(popUpToRouteClass);
                popBackStackInternal$navigation_runtime_release = popBackStackInternal$navigation_runtime_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(popUpToRouteClass)), navOptions.isPopUpToInclusive(), navOptions.shouldPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteObject() != null) {
                Object popUpToRouteObject = navOptions.getPopUpToRouteObject();
                Intrinsics.checkNotNull(popUpToRouteObject);
                popBackStackInternal$navigation_runtime_release = popBackStackInternal$navigation_runtime_release((NavControllerImpl) popUpToRouteObject, navOptions.isPopUpToInclusive(), navOptions.shouldPopUpToSaveState());
            } else if (navOptions.getPopUpToId() != -1) {
                popBackStackInternal$navigation_runtime_release = popBackStackInternal$navigation_runtime_release(navOptions.getPopUpToId(), navOptions.isPopUpToInclusive(), navOptions.shouldPopUpToSaveState());
            }
            z = popBackStackInternal$navigation_runtime_release;
            final Bundle addInDefaultArgs = node.addInDefaultArgs(bundle);
            if (navOptions == null && navOptions.shouldRestoreState() && this.backStackMap.containsKey(Integer.valueOf(node.getId()))) {
                booleanRef.element = restoreStateInternal(node.getId(), addInDefaultArgs, navOptions, extras);
                z2 = false;
            } else {
                z2 = navOptions == null && navOptions.shouldLaunchSingleTop() && launchSingleTopInternal(node, bundle);
                if (!z2) {
                    navigateInternal$navigation_runtime_release(this._navigatorProvider.getNavigator(node.getNavigatorName()), CollectionsKt.listOf(NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, getNavContext(), node, addInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), navOptions, extras, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit navigate$lambda$44;
                            navigate$lambda$44 = NavControllerImpl.navigate$lambda$44(Ref.BooleanRef.this, this, node, addInDefaultArgs, (NavBackStackEntry) obj);
                            return navigate$lambda$44;
                        }
                    });
                }
            }
            this.updateOnBackPressedCallbackEnabledCallback.invoke();
            for (NavController.NavControllerNavigatorState navControllerNavigatorState2 : this.navigatorState.values()) {
                navControllerNavigatorState2.setNavigating(false);
            }
            if (!z || booleanRef.element || z2) {
                dispatchOnDestinationChanged$navigation_runtime_release();
            } else {
                updateBackStackLifecycle$navigation_runtime_release();
                return;
            }
        }
        z = false;
        final Bundle addInDefaultArgs2 = node.addInDefaultArgs(bundle);
        if (navOptions == null) {
        }
        if (navOptions == null) {
        }
        if (!z2) {
        }
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        while (r1.hasNext()) {
        }
        if (!z) {
        }
        dispatchOnDestinationChanged$navigation_runtime_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$44(Ref.BooleanRef booleanRef, NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        booleanRef.element = true;
        addEntryToBackStack$default(navControllerImpl, navDestination, bundle, it, null, 8, null);
        return Unit.INSTANCE;
    }

    private final boolean launchSingleTopInternal(NavDestination navDestination, Bundle bundle) {
        int i;
        NavDestination destination;
        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().getDestination() == navDestination) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return false;
        }
        if (navDestination instanceof NavGraph) {
            List list = SequencesKt.toList(SequencesKt.map(NavGraph.Companion.childHierarchy((NavGraph) navDestination), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int launchSingleTopInternal$lambda$47;
                    launchSingleTopInternal$lambda$47 = NavControllerImpl.launchSingleTopInternal$lambda$47((NavDestination) obj);
                    return Integer.valueOf(launchSingleTopInternal$lambda$47);
                }
            }));
            if (this.backQueue.size() - i != list.size()) {
                return false;
            }
            ArrayDeque<NavBackStackEntry> arrayDeque2 = this.backQueue;
            List<NavBackStackEntry> subList = arrayDeque2.subList(i, arrayDeque2.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
            for (NavBackStackEntry navBackStackEntry : subList) {
                arrayList.add(Integer.valueOf(navBackStackEntry.getDestination().getId()));
            }
            if (!Intrinsics.areEqual(arrayList, list)) {
                return false;
            }
        } else if (currentBackStackEntry$navigation_runtime_release == null || (destination = currentBackStackEntry$navigation_runtime_release.getDestination()) == null || navDestination.getId() != destination.getId()) {
            return false;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        while (CollectionsKt.getLastIndex(this.backQueue) >= i) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.removeLast(this.backQueue);
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry2);
            arrayDeque3.addFirst(new NavBackStackEntry(navBackStackEntry2, navBackStackEntry2.getDestination().addInDefaultArgs(bundle)));
        }
        ArrayDeque<NavBackStackEntry> arrayDeque4 = arrayDeque3;
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque4) {
            NavGraph parent = navBackStackEntry3.getDestination().getParent();
            if (parent != null) {
                linkChildToParent$navigation_runtime_release(navBackStackEntry3, getBackStackEntry$navigation_runtime_release(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry3);
        }
        for (NavBackStackEntry navBackStackEntry4 : arrayDeque4) {
            this._navigatorProvider.getNavigator(navBackStackEntry4.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry4);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int launchSingleTopInternal$lambda$47(NavDestination it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    private final boolean restoreStateInternal(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        if (this.backStackMap.containsKey(Integer.valueOf(i))) {
            final String str = this.backStackMap.get(Integer.valueOf(i));
            CollectionsKt.removeAll(this.backStackMap.values(), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean restoreStateInternal$lambda$51;
                    restoreStateInternal$lambda$51 = NavControllerImpl.restoreStateInternal$lambda$51(str, (String) obj);
                    return Boolean.valueOf(restoreStateInternal$lambda$51);
                }
            });
            return executeRestoreState(instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str)), bundle, navOptions, extras);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean restoreStateInternal$lambda$51(String str, String str2) {
        return Intrinsics.areEqual(str2, str);
    }

    private final boolean restoreStateInternal(String str) {
        NavBackStackEntryState firstOrNull;
        int hashCode = NavDestination.Companion.createRoute(str).hashCode();
        if (this.backStackMap.containsKey(Integer.valueOf(hashCode))) {
            return restoreStateInternal(hashCode, null, null, null);
        }
        NavDestination findDestination$navigation_runtime_release = findDestination$navigation_runtime_release(str);
        if (findDestination$navigation_runtime_release == null) {
            throw new IllegalStateException(("Restore State failed: route " + str + " cannot be found from the current destination " + getCurrentDestination$navigation_runtime_release()).toString());
        }
        final String str2 = this.backStackMap.get(Integer.valueOf(findDestination$navigation_runtime_release.getId()));
        CollectionsKt.removeAll(this.backStackMap.values(), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean restoreStateInternal$lambda$53;
                restoreStateInternal$lambda$53 = NavControllerImpl.restoreStateInternal$lambda$53(str2, (String) obj);
                return Boolean.valueOf(restoreStateInternal$lambda$53);
            }
        });
        ArrayDeque<NavBackStackEntryState> arrayDeque = (ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str2);
        NavDestination.DeepLinkMatch matchRoute = findDestination$navigation_runtime_release.matchRoute(str);
        Intrinsics.checkNotNull(matchRoute);
        if (matchRoute.hasMatchingArgs((arrayDeque == null || (firstOrNull = arrayDeque.firstOrNull()) == null) ? null : firstOrNull.getArgs())) {
            return executeRestoreState(instantiateBackStack(arrayDeque), null, null, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean restoreStateInternal$lambda$53(String str, String str2) {
        return Intrinsics.areEqual(str2, str);
    }

    private final boolean executeRestoreState(final List<NavBackStackEntry> list, final Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list2 = (List) CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
            if (Intrinsics.areEqual((list2 == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last((List<? extends Object>) list2)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list2.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List<NavBackStackEntry> list3 : arrayList) {
            Navigator<? extends NavDestination> navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first((List<? extends Object>) list3)).getDestination().getNavigatorName());
            final Ref.IntRef intRef = new Ref.IntRef();
            navigateInternal$navigation_runtime_release(navigator, list3, navOptions, extras, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit executeRestoreState$lambda$57;
                    executeRestoreState$lambda$57 = NavControllerImpl.executeRestoreState$lambda$57(Ref.BooleanRef.this, list, intRef, this, bundle, (NavBackStackEntry) obj2);
                    return executeRestoreState$lambda$57;
                }
            });
        }
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeRestoreState$lambda$57(Ref.BooleanRef booleanRef, List list, Ref.IntRef intRef, NavControllerImpl navControllerImpl, Bundle bundle, NavBackStackEntry entry) {
        List<NavBackStackEntry> emptyList;
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.element = true;
        int indexOf = list.indexOf(entry);
        if (indexOf != -1) {
            int i = indexOf + 1;
            emptyList = list.subList(intRef.element, i);
            intRef.element = i;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        navControllerImpl.addEntryToBackStack(entry.getDestination(), bundle, entry, emptyList);
        return Unit.INSTANCE;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavGraph graph$navigation_runtime_release;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (graph$navigation_runtime_release = lastOrNull.getDestination()) == null) {
            graph$navigation_runtime_release = getGraph$navigation_runtime_release();
        }
        if (arrayDeque != null) {
            NavDestination navDestination = graph$navigation_runtime_release;
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination findDestinationComprehensive$navigation_runtime_release$default = findDestinationComprehensive$navigation_runtime_release$default(this, navDestination, navBackStackEntryState.getDestinationId(), true, null, 8, null);
                if (findDestinationComprehensive$navigation_runtime_release$default == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(getNavContext(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + navDestination).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(getNavContext(), findDestinationComprehensive$navigation_runtime_release$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                navDestination = findDestinationComprehensive$navigation_runtime_release$default;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void addEntryToBackStack$default(NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        navControllerImpl.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    private final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        Bundle bundle2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavDestination navDestination2;
        List<NavBackStackEntry> list2;
        NavBackStackEntry navBackStackEntry2;
        NavBackStackEntry navBackStackEntry3;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntry4;
        List<NavBackStackEntry> list3 = list;
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof FloatingWindow)) {
            while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof FloatingWindow) && popBackStackInternal$navigation_runtime_release$default(this, this.backQueue.last().getDestination().getId(), true, false, 4, (Object) null)) {
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NavBackStackEntry navBackStackEntry5 = null;
        if (navDestination instanceof NavGraph) {
            NavGraph navGraph2 = destination;
            while (true) {
                Intrinsics.checkNotNull(navGraph2);
                NavGraph parent = navGraph2.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list3.listIterator(list3.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntry4 = null;
                            break;
                        }
                        navBackStackEntry4 = listIterator.previous();
                        if (Intrinsics.areEqual(navBackStackEntry4.getDestination(), parent)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry6 = navBackStackEntry4;
                    if (navBackStackEntry6 == null) {
                        bundle2 = bundle;
                        navDestination2 = destination;
                        navBackStackEntry6 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, getNavContext(), parent, bundle2, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                    } else {
                        bundle2 = bundle;
                        navDestination2 = destination;
                    }
                    arrayDeque2.addFirst(navBackStackEntry6);
                    if (this.backQueue.isEmpty() || this.backQueue.last().getDestination() != parent) {
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        arrayDeque = arrayDeque2;
                        navGraph = parent;
                    } else {
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        popEntryFromBackStack$navigation_runtime_release$default(this, this.backQueue.last(), false, null, 6, null);
                    }
                } else {
                    bundle2 = bundle;
                    arrayDeque = arrayDeque2;
                    navGraph = parent;
                    navDestination2 = destination;
                    list2 = list3;
                    navBackStackEntry2 = navBackStackEntry;
                }
                navGraph2 = navGraph;
                if (navGraph2 == null || navGraph2 == navDestination) {
                    break;
                }
                list3 = list2;
                arrayDeque2 = arrayDeque;
                destination = navDestination2;
            }
        } else {
            bundle2 = bundle;
            arrayDeque = arrayDeque2;
            navDestination2 = destination;
            list2 = list3;
            navBackStackEntry2 = navBackStackEntry;
        }
        NavGraph destination2 = arrayDeque.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque.first()).getDestination();
        while (destination2 != null && findDestination$navigation_runtime_release(destination2.getId(), destination2) != destination2) {
            NavGraph parent2 = destination2.getParent();
            if (parent2 != null) {
                Bundle bundle3 = (bundle2 == null || !SavedStateReader.m7658isEmptyimpl(SavedStateReader.m7580constructorimpl(bundle2))) ? bundle2 : null;
                ListIterator<NavBackStackEntry> listIterator2 = list2.listIterator(list2.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntry3 = null;
                        break;
                    }
                    navBackStackEntry3 = listIterator2.previous();
                    if (Intrinsics.areEqual(navBackStackEntry3.getDestination(), parent2)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry7 = navBackStackEntry3;
                if (navBackStackEntry7 == null) {
                    navBackStackEntry7 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, getNavContext(), parent2, parent2.addInDefaultArgs(bundle3), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                }
                arrayDeque.addFirst(navBackStackEntry7);
            }
            destination2 = parent2;
        }
        if (!arrayDeque.isEmpty()) {
            navDestination2 = ((NavBackStackEntry) arrayDeque.first()).getDestination();
        }
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            NavDestination destination3 = this.backQueue.last().getDestination();
            Intrinsics.checkNotNull(destination3, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) destination3).getNodes().get(navDestination2.getId()) != null) {
                break;
            }
            popEntryFromBackStack$navigation_runtime_release$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry firstOrNull = this.backQueue.firstOrNull();
        if (firstOrNull == null) {
            firstOrNull = (NavBackStackEntry) arrayDeque.firstOrNull();
        }
        if (!Intrinsics.areEqual(firstOrNull != null ? firstOrNull.getDestination() : null, this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list2.listIterator(list2.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator3.previous();
                NavDestination destination4 = previous.getDestination();
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                if (Intrinsics.areEqual(destination4, navGraph3)) {
                    navBackStackEntry5 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry8 = navBackStackEntry5;
            if (navBackStackEntry8 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.Companion;
                NavContext navContext = getNavContext();
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                NavGraph navGraph5 = navGraph4;
                NavGraph navGraph6 = this._graph;
                Intrinsics.checkNotNull(navGraph6);
                navBackStackEntry8 = NavBackStackEntry.Companion.create$default(companion, navContext, navGraph5, navGraph6.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
            }
            arrayDeque.addFirst(navBackStackEntry8);
        }
        for (NavBackStackEntry navBackStackEntry9 : arrayDeque) {
            NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry9.getDestination().getNavigatorName()));
            if (navControllerNavigatorState == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.getNavigatorName() + " should already be created").toString());
            }
            navControllerNavigatorState.addInternal(navBackStackEntry9);
        }
        ArrayDeque arrayDeque3 = arrayDeque;
        this.backQueue.addAll(arrayDeque3);
        this.backQueue.add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry10 : CollectionsKt.plus((Collection<? extends NavBackStackEntry>) arrayDeque3, navBackStackEntry2)) {
            NavGraph parent3 = navBackStackEntry10.getDestination().getParent();
            if (parent3 != null) {
                linkChildToParent$navigation_runtime_release(navBackStackEntry10, getBackStackEntry$navigation_runtime_release(parent3.getId()));
            }
        }
    }

    public final void navigate$navigation_runtime_release(String route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$navigation_runtime_release$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$navigation_runtime_release$default(NavControllerImpl navControllerImpl, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if ((i & 4) != 0) {
            extras = null;
        }
        navControllerImpl.navigate$navigation_runtime_release(str, navOptions, extras);
    }

    public final void navigate$navigation_runtime_release(String route, NavOptions navOptions, Navigator.Extras extras) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        NavGraph topGraph$navigation_runtime_release = getTopGraph$navigation_runtime_release();
        NavDestination.DeepLinkMatch matchRouteComprehensive = topGraph$navigation_runtime_release.matchRouteComprehensive(route, true, true, topGraph$navigation_runtime_release);
        if (matchRouteComprehensive != null) {
            NavDestination destination = matchRouteComprehensive.getDestination();
            Bundle addInDefaultArgs = destination.addInDefaultArgs(matchRouteComprehensive.getMatchingArgs());
            if (addInDefaultArgs == null) {
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
                addInDefaultArgs = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.m7666constructorimpl(addInDefaultArgs);
            }
            NavDestination destination2 = matchRouteComprehensive.getDestination();
            this.navController.writeIntent$navigation_runtime_release(NavDeepLinkRequest.Builder.Companion.fromUri(NavUriKt.NavUri(NavDestination.Companion.createRoute(destination.getRoute()))).build(), addInDefaultArgs);
            navigate$navigation_runtime_release(destination2, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this._graph);
    }

    public final <T> void navigate$navigation_runtime_release(T route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$navigation_runtime_release$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Object obj, NavOptions navOptions, Navigator.Extras extras, int i, Object obj2) {
        if ((i & 4) != 0) {
            extras = null;
        }
        navControllerImpl.navigate$navigation_runtime_release((NavControllerImpl) obj, navOptions, extras);
    }

    public final <T> void navigate$navigation_runtime_release(T route, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route), navOptions, extras);
    }

    public final Bundle saveState$navigation_runtime_release() {
        Pair[] pairArr;
        Bundle bundle;
        Pair[] pairArr2;
        Pair[] pairArr3;
        Pair[] pairArr4;
        Pair[] pairArr5;
        ArrayList arrayList = new ArrayList();
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList2 = new ArrayList(emptyMap.size());
            for (Map.Entry entry : emptyMap.entrySet()) {
                arrayList2.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList2.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7666constructorimpl(bundleOf);
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry2 : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry2.getKey();
            Bundle onSaveState = entry2.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                SavedStateWriter.m7693putSavedStateimpl(SavedStateWriter.m7666constructorimpl(bundleOf), key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            Map emptyMap2 = MapsKt.emptyMap();
            if (emptyMap2.isEmpty()) {
                pairArr5 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(emptyMap2.size());
                for (Map.Entry entry3 : emptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.to((String) entry3.getKey(), entry3.getValue()));
                }
                pairArr5 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr5, pairArr5.length));
            Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
            SavedStateWriter.m7701putStringListimpl(SavedStateWriter.m7666constructorimpl(bundleOf), KEY_NAVIGATOR_STATE_NAMES, arrayList);
            SavedStateWriter.m7693putSavedStateimpl(m7666constructorimpl, KEY_NAVIGATOR_STATE, bundleOf);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                Map emptyMap3 = MapsKt.emptyMap();
                if (emptyMap3.isEmpty()) {
                    pairArr4 = new Pair[0];
                } else {
                    ArrayList arrayList4 = new ArrayList(emptyMap3.size());
                    for (Map.Entry entry4 : emptyMap3.entrySet()) {
                        arrayList4.add(TuplesKt.to((String) entry4.getKey(), entry4.getValue()));
                    }
                    pairArr4 = (Pair[]) arrayList4.toArray(new Pair[0]);
                }
                Bundle bundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr4, pairArr4.length));
                SavedStateWriter.m7666constructorimpl(bundleOf2);
                bundle = bundleOf2;
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it = this.backQueue.iterator();
            while (it.hasNext()) {
                arrayList5.add(new NavBackStackEntryState((NavBackStackEntry) it.next()).writeToState());
            }
            SavedStateWriter.m7695putSavedStateListimpl(SavedStateWriter.m7666constructorimpl(bundle), KEY_BACK_STACK, arrayList5);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                Map emptyMap4 = MapsKt.emptyMap();
                if (emptyMap4.isEmpty()) {
                    pairArr3 = new Pair[0];
                } else {
                    ArrayList arrayList6 = new ArrayList(emptyMap4.size());
                    for (Map.Entry entry5 : emptyMap4.entrySet()) {
                        arrayList6.add(TuplesKt.to((String) entry5.getKey(), entry5.getValue()));
                    }
                    pairArr3 = (Pair[]) arrayList6.toArray(new Pair[0]);
                }
                Bundle bundleOf3 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr3, pairArr3.length));
                SavedStateWriter.m7666constructorimpl(bundleOf3);
                bundle = bundleOf3;
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList7 = new ArrayList();
            int i = 0;
            for (Map.Entry<Integer, String> entry6 : this.backStackMap.entrySet()) {
                int intValue = entry6.getKey().intValue();
                String value = entry6.getValue();
                int i2 = i + 1;
                iArr[i] = intValue;
                if (value == null) {
                    value = "";
                }
                arrayList7.add(value);
                i = i2;
            }
            Bundle m7666constructorimpl2 = SavedStateWriter.m7666constructorimpl(bundle);
            SavedStateWriter.m7684putIntArrayimpl(m7666constructorimpl2, KEY_BACK_STACK_DEST_IDS, iArr);
            SavedStateWriter.m7701putStringListimpl(m7666constructorimpl2, KEY_BACK_STACK_IDS, arrayList7);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                Map emptyMap5 = MapsKt.emptyMap();
                if (emptyMap5.isEmpty()) {
                    pairArr2 = new Pair[0];
                } else {
                    ArrayList arrayList8 = new ArrayList(emptyMap5.size());
                    for (Map.Entry entry7 : emptyMap5.entrySet()) {
                        arrayList8.add(TuplesKt.to((String) entry7.getKey(), entry7.getValue()));
                    }
                    pairArr2 = (Pair[]) arrayList8.toArray(new Pair[0]);
                }
                bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
                SavedStateWriter.m7666constructorimpl(bundle);
            }
            ArrayList arrayList9 = new ArrayList();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry8 : this.backStackStates.entrySet()) {
                String key2 = entry8.getKey();
                arrayList9.add(key2);
                ArrayList arrayList10 = new ArrayList();
                for (NavBackStackEntryState navBackStackEntryState : entry8.getValue()) {
                    arrayList10.add(navBackStackEntryState.writeToState());
                }
                SavedStateWriter.m7695putSavedStateListimpl(SavedStateWriter.m7666constructorimpl(bundle), KEY_BACK_STACK_STATES_PREFIX + key2, arrayList10);
            }
            SavedStateWriter.m7701putStringListimpl(SavedStateWriter.m7666constructorimpl(bundle), KEY_BACK_STACK_STATES_IDS, arrayList9);
        }
        return bundle;
    }

    public final void setLifecycleOwner$navigation_runtime_release(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (Intrinsics.areEqual(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    public final void setViewModelStore$navigation_runtime_release(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        if (Intrinsics.areEqual(this.viewModel, NavControllerViewModel.Companion.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
        this.viewModel = NavControllerViewModel.Companion.getInstance(viewModelStore);
    }

    public final ViewModelStoreOwner getViewModelStoreOwner$navigation_runtime_release(int i) {
        if (this.viewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
        }
        NavBackStackEntry backStackEntry$navigation_runtime_release = getBackStackEntry$navigation_runtime_release(i);
        if (!(backStackEntry$navigation_runtime_release.getDestination() instanceof NavGraph)) {
            throw new IllegalArgumentException(("No NavGraph with ID " + i + " is on the NavController's back stack").toString());
        }
        return backStackEntry$navigation_runtime_release;
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(int i) {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + i + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(String route) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final <T> NavBackStackEntry getBackStackEntry$navigation_runtime_release(KClass<T> route) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        int generateHashCode = RouteSerializerKt.generateHashCode(SerializersKt.serializer(route));
        if (findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), generateHashCode, true, null, 8, null) == null) {
            throw new IllegalArgumentException(("Destination with route " + route.getSimpleName() + " cannot be found in navigation graph " + getGraph$navigation_runtime_release()).toString());
        }
        List<NavBackStackEntry> value = this.currentBackStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == generateHashCode) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + route.getSimpleName() + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final <T> NavBackStackEntry getBackStackEntry$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return getBackStackEntry$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route));
    }

    public final NavBackStackEntry getCurrentBackStackEntry$navigation_runtime_release() {
        return this.backQueue.lastOrNull();
    }

    public final MutableSharedFlow<NavBackStackEntry> get_currentBackStackEntryFlow$navigation_runtime_release() {
        return this._currentBackStackEntryFlow;
    }

    public final NavBackStackEntry getPreviousBackStackEntry$navigation_runtime_release() {
        Object obj;
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    /* compiled from: NavControllerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/internal/NavControllerImpl$Companion;", "", "<init>", "()V", "TAG", "", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "KEY_BACK_STACK", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void restoreState$navigation_runtime_release(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
        this.navigatorStateToRestore = SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_NAVIGATOR_STATE) ? SavedStateReader.m7637getSavedStateimpl(m7580constructorimpl, KEY_NAVIGATOR_STATE) : null;
        int i = 0;
        this.backStackToRestore = SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_BACK_STACK) ? (Bundle[]) SavedStateReader.m7640getSavedStateListimpl(m7580constructorimpl, KEY_BACK_STACK).toArray(new Bundle[0]) : null;
        this.backStackStates.clear();
        if (SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_BACK_STACK_DEST_IDS) && SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_BACK_STACK_IDS)) {
            int[] m7612getIntArrayimpl = SavedStateReader.m7612getIntArrayimpl(m7580constructorimpl, KEY_BACK_STACK_DEST_IDS);
            List<String> m7654getStringListimpl = SavedStateReader.m7654getStringListimpl(m7580constructorimpl, KEY_BACK_STACK_IDS);
            int length = m7612getIntArrayimpl.length;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                this.backStackMap.put(Integer.valueOf(m7612getIntArrayimpl[i]), !Intrinsics.areEqual(m7654getStringListimpl.get(i2), "") ? m7654getStringListimpl.get(i2) : null);
                i++;
                i2 = i3;
            }
        }
        if (SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_BACK_STACK_STATES_IDS)) {
            for (String str : SavedStateReader.m7654getStringListimpl(m7580constructorimpl, KEY_BACK_STACK_STATES_IDS)) {
                if (SavedStateReader.m7581containsimpl(m7580constructorimpl, KEY_BACK_STACK_STATES_PREFIX + str)) {
                    List<Bundle> m7640getSavedStateListimpl = SavedStateReader.m7640getSavedStateListimpl(m7580constructorimpl, KEY_BACK_STACK_STATES_PREFIX + str);
                    Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                    ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>(m7640getSavedStateListimpl.size());
                    for (Bundle bundle2 : m7640getSavedStateListimpl) {
                        arrayDeque.add(new NavBackStackEntryState(bundle2));
                    }
                    map.put(str, arrayDeque);
                }
            }
        }
    }
}

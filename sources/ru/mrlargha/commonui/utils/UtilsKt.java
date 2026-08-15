package ru.mrlargha.commonui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.LruCache;
import android.view.DragEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.elements.hud.presentation.models.ServerInfoItem;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryCatalogKt;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0095\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0003EHM\u001a\u0012\u0010+\u001a\u00020\u001b*\u00020,2\u0006\u0010-\u001a\u00020\u0002\u001a\n\u0010.\u001a\u00020/*\u000200\u001a\n\u00101\u001a\u00020\u0002*\u000200\u001a\"\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u0015\u001a\"\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u00020\u0015\u001a\u0019\u0010P\u001a\u0004\u0018\u00010\u00032\b\u0010Q\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\u0010R\u001a\u0016\u0010S\u001a\u0004\u0018\u00010T*\u00020U2\u0006\u0010V\u001a\u00020\u001aH\u0000\u001a$\u0010W\u001a\b\u0012\u0004\u0012\u00020T0X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020U0\u00052\u0006\u0010V\u001a\u00020\u001aH\u0000\u001a\u0012\u0010Z\u001a\u0004\u0018\u0001032\u0006\u0010[\u001a\u00020TH\u0000\u001a\u0018\u0010\\\u001a\u0004\u0018\u0001032\u0006\u0010[\u001a\u00020TH\u0080@¢\u0006\u0002\u0010]\u001a\u001c\u0010^\u001a\u00020\u001b2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020T0XH\u0080@¢\u0006\u0002\u0010`\u001a\u0018\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015\u001a\u0018\u0010a\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015\u001a\u001e\u0010b\u001a\u00020c2\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010d\u001a\u0012\u0010e\u001a\u0004\u0018\u0001032\u0006\u0010f\u001a\u00020gH\u0002\u001a\u0018\u0010h\u001a\u0004\u0018\u0001032\u0006\u0010i\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010j\u001a\u0012\u0010k\u001a\u0004\u0018\u0001032\u0006\u0010l\u001a\u00020\u0015H\u0002\u001a&\u0010m\u001a\u0004\u0018\u0001032\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002030o2\u0006\u0010l\u001a\u00020\u0015H\u0002\u001a\u001c\u0010p\u001a\u0004\u0018\u0001032\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010q\u001a\u00020\u0002H\u0002\u001a \u0010r\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\u00022\u0006\u0010t\u001a\u00020\u00022\u0006\u0010q\u001a\u00020\u0002H\u0002\u001aM\u0010u\u001a\u0002Hv\"\u0004\b\u0000\u0010v*\u0002Hv2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\bx2\u0017\u0010y\u001a\u0013\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\bxH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010z\u001a&\u0010{\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020U2\u0006\u0010}\u001a\u00020~H\u0007b\f\b\u007f\u0012\b\b\u0004\u0012\u0004\b\u0003\u00100\u001a\u000f\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001*\u00030\u0082\u0001\u001a\u0010\u0010\u0083\u0001\u001a\u00020\u00152\u0007\u0010\u0084\u0001\u001a\u00020\u0015\u001a\u0010\u0010\u0085\u0001\u001a\u00020\u00022\u0007\u0010\u0086\u0001\u001a\u00020\u0002\u001a\u001c\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0015\u001a\u0010\u0010\u008b\u0001\u001a\u00020\u00022\u0007\u0010\u008c\u0001\u001a\u00020\u0002\u001a\u0016\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0007\u0010\u008e\u0001\u001a\u000200\u001a!\u0010\u008f\u0001\u001a\u00020\u001b2\u0006\u0010}\u001a\u00020,2\u0007\u0010\u0090\u0001\u001a\u00020\u00022\u0007\u0010\u008e\u0001\u001a\u000200\u001a\"\u0010\u008f\u0001\u001a\u00020\u001b2\u0007\u0010}\u001a\u00030\u0091\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u00022\u0007\u0010\u008e\u0001\u001a\u000200\u001a\u0010\u0010\u0092\u0001\u001a\u00020\u00152\u0007\u0010\u0093\u0001\u001a\u00020\u0015\u001a\u001a\u0010\u0094\u0001\u001a\u00020\u001b2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u000203\u001a\u001b\u0010\u0098\u0001\u001a\u00020\u001b2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001\u001a3\u0010\u0099\u0001\u001a\u00020\u001b2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u001a2\u0017\b\u0002\u0010\u009b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019\u001a'\u0010\u009c\u0001\u001a\u00020\u001b2\u0013\u0010\u009d\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0007\u0010\u009e\u0001\u001a\u00020\u001aH\u0002\u001a3\u0010\u009f\u0001\u001a\u00020\u001b2\u0007\u0010 \u0001\u001a\u00020\u00152\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0007\u0010\u009e\u0001\u001a\u00020\u001aH\u0082@¢\u0006\u0003\u0010¢\u0001\u001a(\u0010£\u0001\u001a\u00020\u001b2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010¤\u0001\u001a\u00020\u00022\f\b\u0002\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001\u001a,\u0010§\u0001\u001a\u00020\u001b2\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010ª\u0001\u001a\u00020\u00022\u0007\u0010«\u0001\u001a\u00020U2\u0007\u0010¬\u0001\u001a\u00020U\u001a\u001d\u0010\u00ad\u0001\u001a\u0004\u0018\u00010U2\t\u0010®\u0001\u001a\u0004\u0018\u00010U2\u0007\u0010¯\u0001\u001a\u00020U\u001a\u0010\u0010°\u0001\u001a\u00020\u00152\u0007\u0010±\u0001\u001a\u00020\u0015\u001a\u0019\u0010²\u0001\u001a\u00020\u00152\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u00105\u001a\u00020\u0002\u001a\u0019\u0010³\u0001\u001a\u00020\u00152\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u00105\u001a\u00020\u0002\u001a\u0007\u0010´\u0001\u001a\u00020\u0015\u001a\u0014\u0010µ\u0001\u001a\u00020\u00152\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0015H\u0002\u001a\u0011\u0010·\u0001\u001a\u00020\u001a2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001\u001a\u0012\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001\u001a\u0010\u0010º\u0001\u001a\u00020\u00152\u0007\u0010»\u0001\u001a\u00020\u0002\u001a\u0011\u0010¼\u0001\u001a\u00020\u00152\b\u0010½\u0001\u001a\u00030¾\u0001\u001a\u001d\u0010¿\u0001\u001a\u00020\u001b*\u00020,2\u0007\u0010À\u0001\u001a\u00020\u00152\u0007\u0010\u0086\u0001\u001a\u00020\u0002\u001a\r\u0010Á\u0001\u001a\u00030Â\u0001*\u00030\u0089\u0001\u001a*\u0010Ã\u0001\u001a\u00020\u001b2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Ä\u0001\u001a \u0010Å\u0001\u001a\u00020\u001b*\u00030\u0096\u00012\u0007\u0010Æ\u0001\u001a\u00020\u00152\t\b\u0002\u0010Ç\u0001\u001a\u00020\u0015\u001a%\u0010È\u0001\u001a\u00020\u001b*\u00030\u0096\u00012\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Ä\u0001\u001a%\u0010É\u0001\u001a\u00020\u001b*\u00030\u0096\u00012\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Ä\u0001\u001a%\u0010Ê\u0001\u001a\u00020\u001b*\u00030\u0096\u00012\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Ä\u0001\u001a'\u0010Ë\u0001\u001a\u00020\u001b*\u00030\u0096\u00012\b\b\u0002\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0002H\u0086@¢\u0006\u0003\u0010Ì\u0001\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u001d\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\"\u0011\u0010\"\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001f\"\u001a\u0010#\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!\"\u0011\u0010&\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001f\"\u001a\u0010'\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!\"\u0011\u0010*\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001f\"\u000e\u00107\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010C\"\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010F\"\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010I\"\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010N\"\u000e\u0010O\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Í\u0001"}, d2 = {"itemsNameById", "", "", "Lru/mrlargha/commonui/utils/ItemsInfo;", "value", "", "itemsName", "getItemsName", "()Ljava/util/List;", "setItemsName", "(Ljava/util/List;)V", "zipFileIcons", "Ljava/util/zip/ZipFile;", "getZipFileIcons", "()Ljava/util/zip/ZipFile;", "setZipFileIcons", "(Ljava/util/zip/ZipFile;)V", "inventoryCatalogLoadLock", "", "inventoryCatalogLoadingKeys", "", "", "inventoryCatalogCallbacks", "", "", "Lkotlin/Function1;", "", "", "inventoryCatalogSourceKey", "_isArizonaType", "get_isArizonaType", "()Z", "set_isArizonaType", "(Z)V", "isArizonaType", "_isBrazilType", "get_isBrazilType", "set_isBrazilType", "isBrazilType", "_isDebug", "get_isDebug", "set_isDebug", "isDebug", "setTextTimeFormat", "Landroid/widget/TextView;", "time", "getAnimationScale", "", "Landroid/app/Activity;", "getKeyboardHeightOrNull", "getIconFromArchive", "Landroid/graphics/Bitmap;", "folderName", "item", "gearsIconName", "MAX_DIM", "INVENTORY_ICON_MAX_DIM", "ICON_BITMAP_CACHE_BYTES", "INVENTORY_ICON_BITMAP_CACHE_BYTES", "ICON_DECODE_STRIPE_COUNT", "INVENTORY_ICON_PRELOAD_CONCURRENCY", "EFFECT_BYTE_CACHE_BYTES", "iconDecodeLocks", "", "[Ljava/lang/Object;", "inventoryIconDecodeMutexes", "Lkotlinx/coroutines/sync/Mutex;", "[Lkotlinx/coroutines/sync/Mutex;", "iconBitmapCache", "ru/mrlargha/commonui/utils/UtilsKt$iconBitmapCache$1", "Lru/mrlargha/commonui/utils/UtilsKt$iconBitmapCache$1;", "inventoryIconBitmapCache", "ru/mrlargha/commonui/utils/UtilsKt$inventoryIconBitmapCache$1", "Lru/mrlargha/commonui/utils/UtilsKt$inventoryIconBitmapCache$1;", "inventoryIconPreloadSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "effectByteCache", "ru/mrlargha/commonui/utils/UtilsKt$effectByteCache$1", "Lru/mrlargha/commonui/utils/UtilsKt$effectByteCache$1;", "effectByteReadMutex", "getItemInfo", "itemId", "(Ljava/lang/Integer;)Lru/mrlargha/commonui/utils/ItemsInfo;", "toInventoryIconRequest", "Lru/mrlargha/commonui/utils/InventoryIconRequest;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "preferCustomIcon", "inventoryIconRequests", "", "items", "getCachedInventoryIcon", "request", "loadInventoryIcon", "(Lru/mrlargha/commonui/utils/InventoryIconRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadInventoryIcons", "requests", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIconFromArchiveWithFormat", "getArchiveEntryBytesWithFormat", "Lru/mrlargha/commonui/utils/ArchiveEntryBytes;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitmapFromEntry", "entry", "Ljava/util/zip/ZipEntry;", "loadInventoryIconFromArchiveEntry", "entryName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedIconBitmap", "cacheKey", "getCachedBitmap", "cache", "Landroid/util/LruCache;", "decodeBitmapFromEntry", "maxDim", "calculateInSampleSizeToMax", "srcW", "srcH", "applyIf", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setDragClick", "itemVal", "view", "Landroid/view/View;", "Landroidx/annotation/RequiresApi;", "getInventoryDragState", "Lru/mrlargha/commonui/utils/InventoryDragState;", "Landroid/view/DragEvent;", "updateJsonString", "jsonString", "getColorTint", "color", "getJsonFromAssets", "context", "Landroid/content/Context;", "fileName", "nextMultipleOfFive", "x", "getItemsDescription", "targetActivity", "setDrawableEnd", "viewInt", "Landroid/widget/EditText;", "deleteSvgWord", "svg", "setImage", "imageView", "Landroid/widget/ImageView;", "bitmap", "setNotLoadedImage", "checkItemsName", "isArizona", "onComplete", "dispatchInventoryCatalogCallback", "callback", FirebaseAnalytics.Param.SUCCESS, "completeInventoryCatalogLoad", "key", "catalog", "(Ljava/lang/String;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemsJson", "type", "dir", "Ljava/io/File;", "sendData", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "backendID", "fromItem", "toItem", "updateInventoryItem", "originalItem", "newItem", "convertPngToWebp", "png", "defineArzMenuText", "defineRodMenuText", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "getArizonaType", "getServerId", "Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "formatNumberWithSpaces", "number", "formatTime", "millisUntilFinished", "", "setColoredTextBeforeDot", "fullText", "getBaseShredPref", "Landroid/content/SharedPreferences;", "loadGifFromZipAsync", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gifLoadFromCdn", "url", "fallbackImage", "gifGetFromZipAcyncGif", "gifGetFromZipAcync", "setImageFromZipAcync", "setImageFromArchive", "(Landroid/widget/ImageView;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    private static final int EFFECT_BYTE_CACHE_BYTES = 4194304;
    private static final int ICON_BITMAP_CACHE_BYTES = 8388608;
    private static final int ICON_DECODE_STRIPE_COUNT = 4;
    private static final int INVENTORY_ICON_BITMAP_CACHE_BYTES = 25165824;
    private static final int INVENTORY_ICON_MAX_DIM = 256;
    private static final int INVENTORY_ICON_PRELOAD_CONCURRENCY = 4;
    private static final int MAX_DIM = 1024;
    private static boolean _isBrazilType;
    private static final UtilsKt$effectByteCache$1 effectByteCache;
    private static final Mutex effectByteReadMutex;
    private static final UtilsKt$iconBitmapCache$1 iconBitmapCache;
    private static final Object[] iconDecodeLocks;
    private static volatile String inventoryCatalogSourceKey;
    private static final UtilsKt$inventoryIconBitmapCache$1 inventoryIconBitmapCache;
    private static final Mutex[] inventoryIconDecodeMutexes;
    private static final Semaphore inventoryIconPreloadSemaphore;
    private static ZipFile zipFileIcons;
    private static volatile Map<Integer, ItemsInfo> itemsNameById = MapsKt.emptyMap();
    private static volatile List<ItemsInfo> itemsName = CollectionsKt.emptyList();
    private static final Object inventoryCatalogLoadLock = new Object();
    private static final Set<String> inventoryCatalogLoadingKeys = new LinkedHashSet();
    private static final Map<String, List<Function1<Boolean, Unit>>> inventoryCatalogCallbacks = new LinkedHashMap();
    private static boolean _isArizonaType = true;
    private static boolean _isDebug = true;

    /* JADX WARN: Type inference failed for: r1v2, types: [ru.mrlargha.commonui.utils.UtilsKt$effectByteCache$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [ru.mrlargha.commonui.utils.UtilsKt$iconBitmapCache$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [ru.mrlargha.commonui.utils.UtilsKt$inventoryIconBitmapCache$1] */
    static {
        Object[] objArr = new Object[4];
        for (int i = 0; i < 4; i++) {
            objArr[i] = new Object();
        }
        iconDecodeLocks = objArr;
        Mutex[] mutexArr = new Mutex[4];
        for (int i2 = 0; i2 < 4; i2++) {
            mutexArr[i2] = MutexKt.Mutex$default(false, 1, null);
        }
        inventoryIconDecodeMutexes = mutexArr;
        iconBitmapCache = new LruCache<String, Bitmap>() { // from class: ru.mrlargha.commonui.utils.UtilsKt$iconBitmapCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return value.getAllocationByteCount();
            }
        };
        inventoryIconBitmapCache = new LruCache<String, Bitmap>() { // from class: ru.mrlargha.commonui.utils.UtilsKt$inventoryIconBitmapCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return value.getAllocationByteCount();
            }
        };
        inventoryIconPreloadSemaphore = SemaphoreKt.Semaphore$default(4, 0, 2, null);
        effectByteCache = new LruCache<String, byte[]>() { // from class: ru.mrlargha.commonui.utils.UtilsKt$effectByteCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, byte[] value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return value.length;
            }
        };
        effectByteReadMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public static final List<ItemsInfo> getItemsName() {
        return itemsName;
    }

    public static final void setItemsName(List<ItemsInfo> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<ItemsInfo> list = value;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((ItemsInfo) obj).getId()), obj);
        }
        itemsNameById = linkedHashMap;
        itemsName = value;
    }

    public static final ZipFile getZipFileIcons() {
        return zipFileIcons;
    }

    public static final void setZipFileIcons(ZipFile zipFile) {
        zipFileIcons = zipFile;
    }

    public static final boolean get_isArizonaType() {
        return _isArizonaType;
    }

    public static final void set_isArizonaType(boolean z) {
        _isArizonaType = z;
    }

    public static final boolean isArizonaType() {
        return _isArizonaType;
    }

    public static final boolean get_isBrazilType() {
        return _isBrazilType;
    }

    public static final void set_isBrazilType(boolean z) {
        _isBrazilType = z;
    }

    public static final boolean isBrazilType() {
        return _isBrazilType;
    }

    public static final boolean get_isDebug() {
        return _isDebug;
    }

    public static final void set_isDebug(boolean z) {
        _isDebug = z;
    }

    public static final boolean isDebug() {
        return _isDebug;
    }

    public static final void setTextTimeFormat(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    public static final float getAnimationScale(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            return Settings.Global.getFloat(activity.getContentResolver(), "animator_duration_scale", 1.0f);
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public static final int getKeyboardHeightOrNull(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View findViewById = activity.findViewById(16908290);
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        int height = findViewById.getRootView().getHeight();
        int height2 = height - rect.height();
        if (height2 > height * 0.15d) {
            return height2;
        }
        return 0;
    }

    public static /* synthetic */ Bitmap getIconFromArchive$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return getIconFromArchive(str, i, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a A[Catch: Exception -> 0x0060, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:3:0x000b, B:6:0x0015, B:8:0x0019, B:14:0x005a, B:9:0x0033, B:11:0x0037), top: B:20:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getIconFromArchive(String folderName, int i, String gearsIconName) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(gearsIconName, "gearsIconName");
        try {
            if (Intrinsics.areEqual(folderName, "gears")) {
                ZipFile zipFile = zipFileIcons;
                if (zipFile != null) {
                    entry = zipFile.getEntry(folderName + "/" + gearsIconName);
                    if (entry == null) {
                        return getBitmapFromEntry(entry);
                    }
                    return null;
                }
                entry = null;
                if (entry == null) {
                }
            } else {
                ZipFile zipFile2 = zipFileIcons;
                if (zipFile2 != null) {
                    entry = zipFile2.getEntry(folderName + "/" + i + ".webp");
                    if (entry == null) {
                    }
                }
                entry = null;
                if (entry == null) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Bitmap getIconFromArchive$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return getIconFromArchive(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x0010, B:6:0x001a, B:8:0x001e, B:14:0x0059, B:9:0x0038, B:11:0x003c), top: B:20:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getIconFromArchive(String folderName, String item, String gearsIconName) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(gearsIconName, "gearsIconName");
        try {
            if (Intrinsics.areEqual(folderName, "gears")) {
                ZipFile zipFile = zipFileIcons;
                if (zipFile != null) {
                    entry = zipFile.getEntry(folderName + "/" + gearsIconName);
                    if (entry == null) {
                        return getBitmapFromEntry(entry);
                    }
                    return null;
                }
                entry = null;
                if (entry == null) {
                }
            } else {
                ZipFile zipFile2 = zipFileIcons;
                if (zipFile2 != null) {
                    entry = zipFile2.getEntry(folderName + "/" + item);
                    if (entry == null) {
                    }
                }
                entry = null;
                if (entry == null) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final ItemsInfo getItemInfo(Integer num) {
        if (num != null) {
            return itemsNameById.get(Integer.valueOf(num.intValue()));
        }
        return null;
    }

    public static final InventoryIconRequest toInventoryIconRequest(InventoryItem inventoryItem, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(inventoryItem, "<this>");
        Integer item = inventoryItem.getItem();
        String str3 = null;
        if (item != null) {
            int intValue = item.intValue();
            if (inventoryItem.isLocked()) {
                return null;
            }
            String customIcon = inventoryItem.getCustomIcon();
            if (customIcon == null || (str = StringsKt.trim((CharSequence) customIcon).toString()) == null || str.length() <= 0 || StringsKt.equals(str, "false", true) || Intrinsics.areEqual(str, "0")) {
                str = null;
            }
            if (str != null) {
                if (!StringsKt.contains$default((CharSequence) StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), '.', false, 2, (Object) null)) {
                    str = str + ".webp";
                }
                str3 = str;
            }
            if (!z || str3 == null) {
                str2 = "items/" + intValue + ".webp";
            } else {
                str2 = "custom_icon/" + str3;
            }
            return new InventoryIconRequest(str2);
        }
        return null;
    }

    public static final Set<InventoryIconRequest> inventoryIconRequests(List<InventoryItem> items, final boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        return (Set) SequencesKt.toCollection(SequencesKt.mapNotNull(CollectionsKt.asSequence(items), new Function1() { // from class: ru.mrlargha.commonui.utils.UtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UtilsKt.inventoryIconRequests$lambda$0(z, (InventoryItem) obj);
            }
        }), new LinkedHashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final InventoryIconRequest inventoryIconRequests$lambda$0(boolean z, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return toInventoryIconRequest(it, z);
    }

    public static final Bitmap getCachedInventoryIcon(InventoryIconRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return getCachedBitmap(inventoryIconBitmapCache, request.getEntryName());
    }

    public static final Object loadInventoryIcon(InventoryIconRequest inventoryIconRequest, Continuation<? super Bitmap> continuation) {
        return loadInventoryIconFromArchiveEntry(inventoryIconRequest.getEntryName(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object preloadInventoryIcons(Set<InventoryIconRequest> set, Continuation<? super Unit> continuation) {
        UtilsKt$preloadInventoryIcons$1 utilsKt$preloadInventoryIcons$1;
        int i;
        if (continuation instanceof UtilsKt$preloadInventoryIcons$1) {
            utilsKt$preloadInventoryIcons$1 = (UtilsKt$preloadInventoryIcons$1) continuation;
            if ((utilsKt$preloadInventoryIcons$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$preloadInventoryIcons$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$preloadInventoryIcons$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$preloadInventoryIcons$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : set) {
                        if (getCachedInventoryIcon((InventoryIconRequest) obj2) == null) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    utilsKt$preloadInventoryIcons$1.L$0 = SpillingKt.nullOutSpilledVariable(set);
                    utilsKt$preloadInventoryIcons$1.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    utilsKt$preloadInventoryIcons$1.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new UtilsKt$preloadInventoryIcons$2(arrayList2, null), utilsKt$preloadInventoryIcons$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    List list = (List) utilsKt$preloadInventoryIcons$1.L$1;
                    Set set2 = (Set) utilsKt$preloadInventoryIcons$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        utilsKt$preloadInventoryIcons$1 = new UtilsKt$preloadInventoryIcons$1(continuation);
        Object obj3 = utilsKt$preloadInventoryIcons$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$preloadInventoryIcons$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public static final Bitmap getIconFromArchive(String folderName, String item) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null || (entry = zipFile.getEntry(folderName + "/" + item + ".webp")) == null) {
            return null;
        }
        return getBitmapFromEntry(entry);
    }

    public static final Bitmap getIconFromArchiveWithFormat(String folderName, String item) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null || (entry = zipFile.getEntry(folderName + "/" + item)) == null) {
            return null;
        }
        return getBitmapFromEntry(entry);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: all -> 0x0119, TryCatch #3 {all -> 0x0119, blocks: (B:18:0x0061, B:20:0x0069, B:21:0x0070, B:23:0x008d, B:24:0x0094, B:26:0x00bd, B:46:0x0104, B:48:0x010d, B:44:0x00f9, B:45:0x00ff, B:28:0x00c3, B:32:0x00e2), top: B:56:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: all -> 0x0119, TryCatch #3 {all -> 0x0119, blocks: (B:18:0x0061, B:20:0x0069, B:21:0x0070, B:23:0x008d, B:24:0x0094, B:26:0x00bd, B:46:0x0104, B:48:0x010d, B:44:0x00f9, B:45:0x00ff, B:28:0x00c3, B:32:0x00e2), top: B:56:0x0061 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getArchiveEntryBytesWithFormat(String str, String str2, Continuation<? super ArchiveEntryBytes> continuation) {
        UtilsKt$getArchiveEntryBytesWithFormat$1 utilsKt$getArchiveEntryBytesWithFormat$1;
        int i;
        Mutex mutex;
        String str3;
        CoroutineContext coroutineContext;
        ZipFile zipFile;
        ArchiveEntryBytes archiveEntryBytes;
        try {
            if (continuation instanceof UtilsKt$getArchiveEntryBytesWithFormat$1) {
                utilsKt$getArchiveEntryBytesWithFormat$1 = (UtilsKt$getArchiveEntryBytesWithFormat$1) continuation;
                if ((utilsKt$getArchiveEntryBytesWithFormat$1.label & Integer.MIN_VALUE) != 0) {
                    utilsKt$getArchiveEntryBytesWithFormat$1.label -= Integer.MIN_VALUE;
                    Object obj = utilsKt$getArchiveEntryBytesWithFormat$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = utilsKt$getArchiveEntryBytesWithFormat$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineContext context = utilsKt$getArchiveEntryBytesWithFormat$1.getContext();
                        mutex = effectByteReadMutex;
                        utilsKt$getArchiveEntryBytesWithFormat$1.L$0 = str;
                        utilsKt$getArchiveEntryBytesWithFormat$1.L$1 = str2;
                        utilsKt$getArchiveEntryBytesWithFormat$1.L$2 = context;
                        utilsKt$getArchiveEntryBytesWithFormat$1.L$3 = mutex;
                        utilsKt$getArchiveEntryBytesWithFormat$1.label = 1;
                        if (mutex.lock(null, utilsKt$getArchiveEntryBytesWithFormat$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        coroutineContext = context;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        coroutineContext = (CoroutineContext) utilsKt$getArchiveEntryBytesWithFormat$1.L$2;
                        str3 = (String) utilsKt$getArchiveEntryBytesWithFormat$1.L$1;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) utilsKt$getArchiveEntryBytesWithFormat$1.L$3;
                        str = (String) utilsKt$getArchiveEntryBytesWithFormat$1.L$0;
                    }
                    JobKt.ensureActive(coroutineContext);
                    zipFile = zipFileIcons;
                    if (zipFile != null) {
                        archiveEntryBytes = new ArchiveEntryBytes(false, null);
                    } else {
                        ZipEntry entry = zipFile.getEntry(str + "/" + str3);
                        if (entry == null) {
                            archiveEntryBytes = new ArchiveEntryBytes(false, null);
                        } else {
                            String str4 = System.identityHashCode(zipFile) + StringUtils.PROCESS_POSTFIX_DELIMITER + entry.getName();
                            byte[] bArr = effectByteCache.get(str4);
                            if (bArr != null) {
                                archiveEntryBytes = new ArchiveEntryBytes(true, bArr);
                            } else {
                                try {
                                    InputStream inputStream = zipFile.getInputStream(entry);
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
                                    byte[] readBytes = ByteStreamsKt.readBytes(bufferedInputStream);
                                    CloseableKt.closeFinally(bufferedInputStream, null);
                                    CloseableKt.closeFinally(inputStream, null);
                                    archiveEntryBytes = new ArchiveEntryBytes(true, readBytes);
                                } catch (OutOfMemoryError unused) {
                                    archiveEntryBytes = new ArchiveEntryBytes(true, null);
                                } catch (Throwable unused2) {
                                    archiveEntryBytes = new ArchiveEntryBytes(true, null);
                                }
                                JobKt.ensureActive(coroutineContext);
                                byte[] bytes = archiveEntryBytes.getBytes();
                                if (bytes != null) {
                                    effectByteCache.put(str4, bytes);
                                }
                            }
                        }
                    }
                    return archiveEntryBytes;
                }
            }
            JobKt.ensureActive(coroutineContext);
            zipFile = zipFileIcons;
            if (zipFile != null) {
            }
            return archiveEntryBytes;
        } finally {
            mutex.unlock(null);
        }
        utilsKt$getArchiveEntryBytesWithFormat$1 = new UtilsKt$getArchiveEntryBytesWithFormat$1(continuation);
        Object obj2 = utilsKt$getArchiveEntryBytesWithFormat$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$getArchiveEntryBytesWithFormat$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap getBitmapFromEntry(ZipEntry zipEntry) {
        Bitmap cachedIconBitmap;
        String name = zipEntry.getName();
        Intrinsics.checkNotNull(name);
        Bitmap cachedIconBitmap2 = getCachedIconBitmap(name);
        if (cachedIconBitmap2 != null) {
            return cachedIconBitmap2;
        }
        synchronized (iconDecodeLocks[(name.hashCode() & Integer.MAX_VALUE) % 4]) {
            cachedIconBitmap = getCachedIconBitmap(name);
            if (cachedIconBitmap == null) {
                cachedIconBitmap = decodeBitmapFromEntry$default(zipEntry, 0, 2, null);
                if (cachedIconBitmap != null) {
                    iconBitmapCache.put(name, cachedIconBitmap);
                } else {
                    cachedIconBitmap = null;
                }
            }
        }
        return cachedIconBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[Catch: all -> 0x00ae, TryCatch #0 {all -> 0x00ae, blocks: (B:26:0x008f, B:28:0x009d, B:30:0x00a5), top: B:39:0x008f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadInventoryIconFromArchiveEntry(String str, Continuation<? super Bitmap> continuation) {
        UtilsKt$loadInventoryIconFromArchiveEntry$1 utilsKt$loadInventoryIconFromArchiveEntry$1;
        int i;
        CoroutineContext context;
        ZipEntry entry;
        Mutex mutex;
        ZipEntry zipEntry;
        Bitmap cachedBitmap;
        try {
            if (continuation instanceof UtilsKt$loadInventoryIconFromArchiveEntry$1) {
                utilsKt$loadInventoryIconFromArchiveEntry$1 = (UtilsKt$loadInventoryIconFromArchiveEntry$1) continuation;
                if ((utilsKt$loadInventoryIconFromArchiveEntry$1.label & Integer.MIN_VALUE) != 0) {
                    utilsKt$loadInventoryIconFromArchiveEntry$1.label -= Integer.MIN_VALUE;
                    Object obj = utilsKt$loadInventoryIconFromArchiveEntry$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = utilsKt$loadInventoryIconFromArchiveEntry$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Bitmap cachedBitmap2 = getCachedBitmap(inventoryIconBitmapCache, str);
                        if (cachedBitmap2 != null) {
                            return cachedBitmap2;
                        }
                        context = utilsKt$loadInventoryIconFromArchiveEntry$1.getContext();
                        JobKt.ensureActive(context);
                        ZipFile zipFile = zipFileIcons;
                        if (zipFile == null || (entry = zipFile.getEntry(str)) == null) {
                            return null;
                        }
                        mutex = inventoryIconDecodeMutexes[(str.hashCode() & Integer.MAX_VALUE) % 4];
                        utilsKt$loadInventoryIconFromArchiveEntry$1.L$0 = str;
                        utilsKt$loadInventoryIconFromArchiveEntry$1.L$1 = context;
                        utilsKt$loadInventoryIconFromArchiveEntry$1.L$2 = entry;
                        utilsKt$loadInventoryIconFromArchiveEntry$1.L$3 = SpillingKt.nullOutSpilledVariable(mutex);
                        utilsKt$loadInventoryIconFromArchiveEntry$1.L$4 = mutex;
                        utilsKt$loadInventoryIconFromArchiveEntry$1.label = 1;
                        if (mutex.lock(null, utilsKt$loadInventoryIconFromArchiveEntry$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zipEntry = entry;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Mutex mutex2 = (Mutex) utilsKt$loadInventoryIconFromArchiveEntry$1.L$3;
                        zipEntry = (ZipEntry) utilsKt$loadInventoryIconFromArchiveEntry$1.L$2;
                        context = (CoroutineContext) utilsKt$loadInventoryIconFromArchiveEntry$1.L$1;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) utilsKt$loadInventoryIconFromArchiveEntry$1.L$4;
                        str = (String) utilsKt$loadInventoryIconFromArchiveEntry$1.L$0;
                    }
                    JobKt.ensureActive(context);
                    UtilsKt$inventoryIconBitmapCache$1 utilsKt$inventoryIconBitmapCache$1 = inventoryIconBitmapCache;
                    cachedBitmap = getCachedBitmap(utilsKt$inventoryIconBitmapCache$1, str);
                    if (cachedBitmap == null) {
                        cachedBitmap = decodeBitmapFromEntry(zipEntry, 256);
                        if (cachedBitmap != null) {
                            utilsKt$inventoryIconBitmapCache$1.put(str, cachedBitmap);
                        } else {
                            cachedBitmap = null;
                        }
                    }
                    return cachedBitmap;
                }
            }
            JobKt.ensureActive(context);
            UtilsKt$inventoryIconBitmapCache$1 utilsKt$inventoryIconBitmapCache$12 = inventoryIconBitmapCache;
            cachedBitmap = getCachedBitmap(utilsKt$inventoryIconBitmapCache$12, str);
            if (cachedBitmap == null) {
            }
            return cachedBitmap;
        } finally {
            mutex.unlock(null);
        }
        utilsKt$loadInventoryIconFromArchiveEntry$1 = new UtilsKt$loadInventoryIconFromArchiveEntry$1(continuation);
        Object obj2 = utilsKt$loadInventoryIconFromArchiveEntry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$loadInventoryIconFromArchiveEntry$1.label;
        if (i != 0) {
        }
    }

    private static final Bitmap getCachedIconBitmap(String str) {
        return getCachedBitmap(iconBitmapCache, str);
    }

    private static final Bitmap getCachedBitmap(LruCache<String, Bitmap> lruCache, String str) {
        Bitmap bitmap = lruCache.get(str);
        if (bitmap == null) {
            return null;
        }
        if (bitmap.isRecycled()) {
            lruCache.remove(str);
            return null;
        }
        return bitmap;
    }

    static /* synthetic */ Bitmap decodeBitmapFromEntry$default(ZipEntry zipEntry, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1024;
        }
        return decodeBitmapFromEntry(zipEntry, i);
    }

    private static final Bitmap decodeBitmapFromEntry(ZipEntry zipEntry, int i) {
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inScaled = false;
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseableKt.closeFinally(bufferedInputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                if (i2 <= 0 || i3 <= 0) {
                    return null;
                }
                int calculateInSampleSizeToMax = calculateInSampleSizeToMax(i2, i3, i);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = calculateInSampleSizeToMax;
                options2.inDither = true;
                options2.inScaled = false;
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 32768);
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                    CloseableKt.closeFinally(bufferedInputStream2, null);
                    CloseableKt.closeFinally(inputStream, null);
                    if (decodeStream == null) {
                        return null;
                    }
                    if (decodeStream.getWidth() > i || decodeStream.getHeight() > i) {
                        float f = i;
                        float min = Math.min(f / decodeStream.getWidth(), f / decodeStream.getHeight());
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, RangesKt.coerceAtLeast((int) (decodeStream.getWidth() * min), 1), RangesKt.coerceAtLeast((int) (decodeStream.getHeight() * min), 1), true);
                        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
                        if (createScaledBitmap != decodeStream) {
                            decodeStream.recycle();
                        }
                        return createScaledBitmap;
                    }
                    return decodeStream;
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final int calculateInSampleSizeToMax(int i, int i2, int i3) {
        int i4 = 1;
        int i5 = i;
        int i6 = i2;
        while (true) {
            if (i5 <= i3 && i6 <= i3) {
                return i4;
            }
            i4 <<= 1;
            i5 = i / i4;
            i6 = i2 / i4;
        }
    }

    public static final <T> T applyIf(T t, Function1<? super T, Boolean> predicate, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(block, "block");
        if (predicate.invoke(t).booleanValue()) {
            block.invoke(t);
        }
        return t;
    }

    public static final boolean setDragClick(InventoryItem itemVal, View view) {
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        Intrinsics.checkNotNullParameter(view, "view");
        view.startDragAndDrop(null, new View.DragShadowBuilder(view), new InventoryDragState(InventoryItem.copy$default(itemVal, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 133955583, null), view), 0);
        return true;
    }

    public static final InventoryDragState getInventoryDragState(DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(dragEvent, "<this>");
        Object localState = dragEvent.getLocalState();
        if (localState instanceof InventoryDragState) {
            return (InventoryDragState) localState;
        }
        return null;
    }

    public static final String updateJsonString(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JsonObject jsonObject = (JsonObject) new Gson().fromJson(jsonString, (Class<Object>) JsonObject.class);
        jsonObject.remove("photoBitmap");
        String json = new Gson().toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static final int getColorTint(int i) {
        return Color.argb(i & 255, (i >> 24) & 255, (i >> 16) & 255, (i >> 8) & 255);
    }

    public static final String getJsonFromAssets(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            InputStream open = context.getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int nextMultipleOfFive(int i) {
        return ((i + 4) / 5) * 5;
    }

    public static final List<String> getItemsDescription(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        if (isArizonaType()) {
            List<String> mutableList = CollectionsKt.toMutableList((Collection) ConstantsKt.getItemsDescription());
            int id = ItemTypes.ITEM_TYPE_GUN_SKIN.getId();
            String string = targetActivity.getString(R.string.inventory_gun_skin_description);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            mutableList.set(id, string);
            int id2 = ItemTypes.ITEM_TYPE_STRIPE_WEAPON.getId();
            String string2 = targetActivity.getString(R.string.inventory_stripe_weapon_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            mutableList.set(id2, string2);
            int id3 = ItemTypes.ITEM_TYPE_GRAPHIC_PRESET.getId();
            String string3 = targetActivity.getString(R.string.inventory_graphic_preset_description);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            mutableList.set(id3, string3);
            int id4 = ItemTypes.ITEM_TYPE_VEH_NUMBER_FRAME.getId();
            String string4 = targetActivity.getString(R.string.inventory_veh_number_frame_description);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            mutableList.set(id4, string4);
            return mutableList;
        }
        return ConstantsKt.getRodinaItemsDescription();
    }

    public static final void setDrawableEnd(TextView view, int i, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        view.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(targetActivity, i), (Drawable) null);
    }

    public static final void setDrawableEnd(EditText view, int i, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        view.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(targetActivity, i), (Drawable) null);
    }

    public static final String deleteSvgWord(String svg) {
        Intrinsics.checkNotNullParameter(svg, "svg");
        return StringsKt.replace$default(svg, ".svg", "", false, 4, (Object) null);
    }

    public static final void setImage(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        imageView.setImageBitmap(bitmap);
    }

    public static final void setNotLoadedImage(ImageView imageView, Context context) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(context, "context");
        imageView.setImageResource(R.drawable.baseline_warning_24);
    }

    public static /* synthetic */ void checkItemsName$default(Context context, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        checkItemsName(context, z, function1);
    }

    public static final void checkItemsName(Context context, boolean z, Function1<? super Boolean, Unit> function1) {
        boolean z2;
        boolean z3;
        Object m9916constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        String inventoryCatalogKey = InventoryCatalogKt.inventoryCatalogKey(z);
        synchronized (inventoryCatalogLoadLock) {
            z2 = !itemsName.isEmpty() && Intrinsics.areEqual(inventoryCatalogSourceKey, inventoryCatalogKey);
            if (z2) {
                z3 = false;
            } else {
                if (function1 != null) {
                    Map<String, List<Function1<Boolean, Unit>>> map = inventoryCatalogCallbacks;
                    ArrayList arrayList = map.get(inventoryCatalogKey);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(inventoryCatalogKey, arrayList);
                    }
                    arrayList.add(function1);
                }
                z3 = inventoryCatalogLoadingKeys.add(inventoryCatalogKey);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z2) {
            if (function1 != null) {
                dispatchInventoryCatalogCallback(function1, true);
            }
        } else if (z3) {
            try {
                Result.Companion companion = Result.Companion;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(applicationContext, 0);
                m9916constructorimpl = Result.m9916constructorimpl(TuplesKt.to(arizonaRetrofit, ArizonaRetrofit.create$default(arizonaRetrofit, InventoryApi.class, false, null, null, 14, null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
            if (m9919exceptionOrNullimpl != null) {
                Log.e("InventoryCatalog", "Unable to create catalog '" + inventoryCatalogKey + "' request", m9919exceptionOrNullimpl);
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new UtilsKt$checkItemsName$clientAndApi$2$1(inventoryCatalogKey, null), 3, null);
                return;
            }
            Pair pair = (Pair) m9916constructorimpl;
            BuildersKt.launch$default(((ArizonaRetrofit) pair.component1()).getScope(), Dispatchers.getIO(), null, new UtilsKt$checkItemsName$3((InventoryApi) pair.component2(), inventoryCatalogKey, null), 2, null);
        }
    }

    private static final void dispatchInventoryCatalogCallback(Function1<? super Boolean, Unit> function1, boolean z) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new UtilsKt$dispatchInventoryCatalogCallback$1(function1, z, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object completeInventoryCatalogLoad(String str, List<ItemsInfo> list, boolean z, Continuation<? super Unit> continuation) {
        List<Function1<Boolean, Unit>> remove;
        synchronized (inventoryCatalogLoadLock) {
            if (list != null) {
                setItemsName(list);
                inventoryCatalogSourceKey = str;
            }
            inventoryCatalogLoadingKeys.remove(str);
            remove = inventoryCatalogCallbacks.remove(str);
            if (remove == null) {
                remove = CollectionsKt.emptyList();
            }
        }
        Object withContext = BuildersKt.withContext(NonCancellable.INSTANCE.plus(Dispatchers.getMain()), new UtilsKt$completeInventoryCatalogLoad$2(remove, z, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static /* synthetic */ void getItemsJson$default(Context context, int i, File file, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            file = context.getExternalFilesDir(null);
        }
        getItemsJson(context, i, file);
    }

    public static final void getItemsJson(Context context, int i, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (file == null) {
            Log.w("getItemsJson", "External files dir is null");
        } else {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UtilsKt$getItemsJson$1(i, file, context, null), 3, null);
        }
    }

    public static final void sendData(IBackendNotifier frontendNotifier, int i, InventoryItem fromItem, InventoryItem toItem) {
        long j;
        Intrinsics.checkNotNullParameter(frontendNotifier, "frontendNotifier");
        Intrinsics.checkNotNullParameter(fromItem, "fromItem");
        Intrinsics.checkNotNullParameter(toItem, "toItem");
        if (fromItem.getAmount() != null) {
            Long amount = fromItem.getAmount();
            j = amount != null ? amount.longValue() : 0L;
        } else {
            j = 1;
        }
        long j2 = j;
        if (fromItem.getSlot() == toItem.getSlot() && fromItem.getInventoryType() == toItem.getInventoryType()) {
            Log.d("TAG_SEND", "EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "backendID: " + i + " ====== from : " + fromItem + " ===== toItem : " + toItem);
        byte[] bytes = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(fromItem.getSlot(), fromItem.getInventoryType(), j2, fromItem.getId()), new ChangeToSlot(toItem.getSlot(), toItem.getInventoryType()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        frontendNotifier.clickedWrapper(i, -1, 1, bytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final InventoryItem updateInventoryItem(InventoryItem inventoryItem, InventoryItem newItem) {
        Integer num;
        Long amount;
        Integer color;
        Integer bits;
        Integer available;
        Integer enchant;
        Integer num2;
        Integer blackout;
        Long time;
        Integer itemStrength;
        Integer isActive;
        Integer breaks;
        Integer acsSlot;
        String str;
        Integer num3;
        Integer gunSlot;
        Integer num4;
        Bitmap photoBitmap;
        String effect;
        String str2;
        Integer effectType;
        Integer num5;
        Integer quality;
        Integer num6;
        String customIcon;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        boolean areEqual = Intrinsics.areEqual(inventoryItem != null ? inventoryItem.getItem() : null, newItem.getItem());
        if (inventoryItem != null) {
            int slot = newItem.getSlot();
            Integer item = newItem.getItem();
            if (item == null) {
                item = inventoryItem.getItem();
            }
            Integer num7 = item;
            int id = newItem.getId();
            String text = newItem.getText();
            if (text == null) {
                text = inventoryItem.getText();
            }
            String str3 = text;
            Integer item_type = newItem.getItem_type();
            if (item_type == null) {
                item_type = inventoryItem.getItem_type();
                if (!areEqual) {
                    num = null;
                    amount = newItem.getAmount();
                    if (amount == null) {
                        amount = inventoryItem.getAmount();
                    }
                    Long l = amount;
                    Integer background = newItem.getBackground();
                    color = newItem.getColor();
                    if (color == null) {
                        color = inventoryItem.getColor();
                    }
                    Integer num8 = color;
                    bits = newItem.getBits();
                    if (bits == null) {
                        bits = inventoryItem.getBits();
                    }
                    Integer num9 = bits;
                    available = newItem.getAvailable();
                    if (available == null) {
                        available = inventoryItem.getAvailable();
                    }
                    Integer num10 = available;
                    enchant = newItem.getEnchant();
                    if (enchant == null) {
                        enchant = inventoryItem.getEnchant();
                        if (!areEqual) {
                            num2 = null;
                            blackout = newItem.getBlackout();
                            if (blackout == null) {
                                blackout = inventoryItem.getBlackout();
                            }
                            Integer num11 = blackout;
                            time = newItem.getTime();
                            if (time == null) {
                                time = inventoryItem.getTime();
                            }
                            Long l2 = time;
                            itemStrength = newItem.getItemStrength();
                            if (itemStrength == null) {
                                itemStrength = inventoryItem.getItemStrength();
                            }
                            Integer num12 = itemStrength;
                            isActive = newItem.isActive();
                            if (isActive == null) {
                                isActive = inventoryItem.isActive();
                            }
                            Integer num13 = isActive;
                            breaks = newItem.getBreaks();
                            if (breaks == null) {
                                breaks = inventoryItem.getBreaks();
                            }
                            Integer num14 = breaks;
                            int inventoryType = newItem.getInventoryType();
                            acsSlot = newItem.getAcsSlot();
                            if (acsSlot == null) {
                                acsSlot = inventoryItem.getAcsSlot();
                                if (newItem.getItem() != null) {
                                    str = null;
                                    int intValue = newItem.getItem().intValue();
                                    Integer item2 = inventoryItem.getItem();
                                    if (item2 == null || intValue != item2.intValue()) {
                                        num3 = null;
                                        gunSlot = newItem.getGunSlot();
                                        if (gunSlot == null) {
                                            gunSlot = inventoryItem.getGunSlot();
                                            if (newItem.getItem() != null) {
                                                int intValue2 = newItem.getItem().intValue();
                                                Integer item3 = inventoryItem.getItem();
                                                if (item3 == null || intValue2 != item3.intValue()) {
                                                    num4 = str;
                                                    photoBitmap = newItem.getPhotoBitmap();
                                                    if (photoBitmap == null) {
                                                        photoBitmap = inventoryItem.getPhotoBitmap();
                                                        if (!areEqual) {
                                                            photoBitmap = str;
                                                        }
                                                    }
                                                    effect = newItem.getEffect();
                                                    if (effect == null) {
                                                        effect = inventoryItem.getEffect();
                                                        if (!areEqual) {
                                                            str2 = str;
                                                            effectType = newItem.getEffectType();
                                                            if (effectType == null) {
                                                                effectType = inventoryItem.getEffectType();
                                                                if (!areEqual) {
                                                                    num5 = str;
                                                                    quality = newItem.getQuality();
                                                                    if (quality == null) {
                                                                        quality = inventoryItem.getQuality();
                                                                        if (!areEqual) {
                                                                            num6 = str;
                                                                            customIcon = newItem.getCustomIcon();
                                                                            if (customIcon == null) {
                                                                                customIcon = inventoryItem.getCustomIcon();
                                                                            }
                                                                            String str4 = customIcon;
                                                                            Boolean loading = newItem.getLoading();
                                                                            return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str4, Boolean.valueOf(loading != null ? loading.booleanValue() : false), num4, 1572864, null);
                                                                        }
                                                                    }
                                                                    num6 = quality;
                                                                    customIcon = newItem.getCustomIcon();
                                                                    if (customIcon == null) {
                                                                    }
                                                                    String str42 = customIcon;
                                                                    Boolean loading2 = newItem.getLoading();
                                                                    return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str42, Boolean.valueOf(loading2 != null ? loading2.booleanValue() : false), num4, 1572864, null);
                                                                }
                                                            }
                                                            num5 = effectType;
                                                            quality = newItem.getQuality();
                                                            if (quality == null) {
                                                            }
                                                            num6 = quality;
                                                            customIcon = newItem.getCustomIcon();
                                                            if (customIcon == null) {
                                                            }
                                                            String str422 = customIcon;
                                                            Boolean loading22 = newItem.getLoading();
                                                            return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str422, Boolean.valueOf(loading22 != null ? loading22.booleanValue() : false), num4, 1572864, null);
                                                        }
                                                    }
                                                    str2 = effect;
                                                    effectType = newItem.getEffectType();
                                                    if (effectType == null) {
                                                    }
                                                    num5 = effectType;
                                                    quality = newItem.getQuality();
                                                    if (quality == null) {
                                                    }
                                                    num6 = quality;
                                                    customIcon = newItem.getCustomIcon();
                                                    if (customIcon == null) {
                                                    }
                                                    String str4222 = customIcon;
                                                    Boolean loading222 = newItem.getLoading();
                                                    return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str4222, Boolean.valueOf(loading222 != null ? loading222.booleanValue() : false), num4, 1572864, null);
                                                }
                                            }
                                        }
                                        num4 = gunSlot;
                                        photoBitmap = newItem.getPhotoBitmap();
                                        if (photoBitmap == null) {
                                        }
                                        effect = newItem.getEffect();
                                        if (effect == null) {
                                        }
                                        str2 = effect;
                                        effectType = newItem.getEffectType();
                                        if (effectType == null) {
                                        }
                                        num5 = effectType;
                                        quality = newItem.getQuality();
                                        if (quality == null) {
                                        }
                                        num6 = quality;
                                        customIcon = newItem.getCustomIcon();
                                        if (customIcon == null) {
                                        }
                                        String str42222 = customIcon;
                                        Boolean loading2222 = newItem.getLoading();
                                        return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str42222, Boolean.valueOf(loading2222 != null ? loading2222.booleanValue() : false), num4, 1572864, null);
                                    }
                                    num3 = acsSlot;
                                    gunSlot = newItem.getGunSlot();
                                    if (gunSlot == null) {
                                    }
                                    num4 = gunSlot;
                                    photoBitmap = newItem.getPhotoBitmap();
                                    if (photoBitmap == null) {
                                    }
                                    effect = newItem.getEffect();
                                    if (effect == null) {
                                    }
                                    str2 = effect;
                                    effectType = newItem.getEffectType();
                                    if (effectType == null) {
                                    }
                                    num5 = effectType;
                                    quality = newItem.getQuality();
                                    if (quality == null) {
                                    }
                                    num6 = quality;
                                    customIcon = newItem.getCustomIcon();
                                    if (customIcon == null) {
                                    }
                                    String str422222 = customIcon;
                                    Boolean loading22222 = newItem.getLoading();
                                    return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str422222, Boolean.valueOf(loading22222 != null ? loading22222.booleanValue() : false), num4, 1572864, null);
                                }
                            }
                            str = null;
                            num3 = acsSlot;
                            gunSlot = newItem.getGunSlot();
                            if (gunSlot == null) {
                            }
                            num4 = gunSlot;
                            photoBitmap = newItem.getPhotoBitmap();
                            if (photoBitmap == null) {
                            }
                            effect = newItem.getEffect();
                            if (effect == null) {
                            }
                            str2 = effect;
                            effectType = newItem.getEffectType();
                            if (effectType == null) {
                            }
                            num5 = effectType;
                            quality = newItem.getQuality();
                            if (quality == null) {
                            }
                            num6 = quality;
                            customIcon = newItem.getCustomIcon();
                            if (customIcon == null) {
                            }
                            String str4222222 = customIcon;
                            Boolean loading222222 = newItem.getLoading();
                            return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num11, l2, num12, num13, num14, inventoryType, num3, photoBitmap, false, false, str2, num5, num6, str4222222, Boolean.valueOf(loading222222 != null ? loading222222.booleanValue() : false), num4, 1572864, null);
                        }
                    }
                    num2 = enchant;
                    blackout = newItem.getBlackout();
                    if (blackout == null) {
                    }
                    Integer num112 = blackout;
                    time = newItem.getTime();
                    if (time == null) {
                    }
                    Long l22 = time;
                    itemStrength = newItem.getItemStrength();
                    if (itemStrength == null) {
                    }
                    Integer num122 = itemStrength;
                    isActive = newItem.isActive();
                    if (isActive == null) {
                    }
                    Integer num132 = isActive;
                    breaks = newItem.getBreaks();
                    if (breaks == null) {
                    }
                    Integer num142 = breaks;
                    int inventoryType2 = newItem.getInventoryType();
                    acsSlot = newItem.getAcsSlot();
                    if (acsSlot == null) {
                    }
                    str = null;
                    num3 = acsSlot;
                    gunSlot = newItem.getGunSlot();
                    if (gunSlot == null) {
                    }
                    num4 = gunSlot;
                    photoBitmap = newItem.getPhotoBitmap();
                    if (photoBitmap == null) {
                    }
                    effect = newItem.getEffect();
                    if (effect == null) {
                    }
                    str2 = effect;
                    effectType = newItem.getEffectType();
                    if (effectType == null) {
                    }
                    num5 = effectType;
                    quality = newItem.getQuality();
                    if (quality == null) {
                    }
                    num6 = quality;
                    customIcon = newItem.getCustomIcon();
                    if (customIcon == null) {
                    }
                    String str42222222 = customIcon;
                    Boolean loading2222222 = newItem.getLoading();
                    return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l, background, num8, num9, num10, num2, num112, l22, num122, num132, num142, inventoryType2, num3, photoBitmap, false, false, str2, num5, num6, str42222222, Boolean.valueOf(loading2222222 != null ? loading2222222.booleanValue() : false), num4, 1572864, null);
                }
            }
            num = item_type;
            amount = newItem.getAmount();
            if (amount == null) {
            }
            Long l3 = amount;
            Integer background2 = newItem.getBackground();
            color = newItem.getColor();
            if (color == null) {
            }
            Integer num82 = color;
            bits = newItem.getBits();
            if (bits == null) {
            }
            Integer num92 = bits;
            available = newItem.getAvailable();
            if (available == null) {
            }
            Integer num102 = available;
            enchant = newItem.getEnchant();
            if (enchant == null) {
            }
            num2 = enchant;
            blackout = newItem.getBlackout();
            if (blackout == null) {
            }
            Integer num1122 = blackout;
            time = newItem.getTime();
            if (time == null) {
            }
            Long l222 = time;
            itemStrength = newItem.getItemStrength();
            if (itemStrength == null) {
            }
            Integer num1222 = itemStrength;
            isActive = newItem.isActive();
            if (isActive == null) {
            }
            Integer num1322 = isActive;
            breaks = newItem.getBreaks();
            if (breaks == null) {
            }
            Integer num1422 = breaks;
            int inventoryType22 = newItem.getInventoryType();
            acsSlot = newItem.getAcsSlot();
            if (acsSlot == null) {
            }
            str = null;
            num3 = acsSlot;
            gunSlot = newItem.getGunSlot();
            if (gunSlot == null) {
            }
            num4 = gunSlot;
            photoBitmap = newItem.getPhotoBitmap();
            if (photoBitmap == null) {
            }
            effect = newItem.getEffect();
            if (effect == null) {
            }
            str2 = effect;
            effectType = newItem.getEffectType();
            if (effectType == null) {
            }
            num5 = effectType;
            quality = newItem.getQuality();
            if (quality == null) {
            }
            num6 = quality;
            customIcon = newItem.getCustomIcon();
            if (customIcon == null) {
            }
            String str422222222 = customIcon;
            Boolean loading22222222 = newItem.getLoading();
            return InventoryItem.copy$default(inventoryItem, slot, num7, id, str3, num, l3, background2, num82, num92, num102, num2, num1122, l222, num1222, num1322, num1422, inventoryType22, num3, photoBitmap, false, false, str2, num5, num6, str422222222, Boolean.valueOf(loading22222222 != null ? loading22222222.booleanValue() : false), num4, 1572864, null);
        }
        return null;
    }

    public static final String convertPngToWebp(String png) {
        Intrinsics.checkNotNullParameter(png, "png");
        return StringsKt.replace$default(png, "png", "webp", false, 4, (Object) null);
    }

    public static final String defineArzMenuText(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == ArzInventoryButtonTypes.BUTTON_INVENTORY.ordinal()) {
            String string = context.getString(R.string.inventory);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal()) {
            String string2 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CHEST.ordinal()) {
            String string3 = context.getString(R.string.warehouse_chest);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOTEL_ROOM.ordinal()) {
            String string4 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRUNK.ordinal()) {
            String string5 = context.getString(R.string.warehouse_trunk);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        } else if (i == ArzInventoryButtonTypes.BUTTON_FAM_FLAT.ordinal()) {
            String string6 = context.getString(R.string.warehouse_family);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOUSE.ordinal()) {
            String string7 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRAILER.ordinal()) {
            String string8 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        } else if (i == ArzInventoryButtonTypes.BUTTON_STOREHOUSE.ordinal()) {
            String string9 = context.getString(R.string.warehouse_storehouse);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        } else if (i == ArzInventoryButtonTypes.BUTTON_PAWNSHOP.ordinal()) {
            String string10 = context.getString(R.string.warehouse_lombard_menu);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRASH.ordinal()) {
            String string11 = context.getString(R.string.warehouse_trash);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        } else if (i == ArzInventoryButtonTypes.BUTTON_SECURITY.ordinal()) {
            String string12 = context.getString(R.string.security_guards);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CARS.ordinal()) {
            String string13 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        } else if (i == ArzInventoryButtonTypes.BUTTON_BIZ.ordinal()) {
            String string14 = context.getString(R.string.my_businesses);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOUSES.ordinal()) {
            String string15 = context.getString(R.string.my_houses);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        } else {
            return "";
        }
    }

    public static final String defineRodMenuText(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == RodInventoryButtonTypes.BUTTON_INVENTORY.ordinal()) {
            String string = context.getString(R.string.inventory);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == RodInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal()) {
            String string2 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRASH.ordinal()) {
            String string3 = context.getString(R.string.warehouse_trash);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRUNK.ordinal()) {
            String string4 = context.getString(R.string.warehouse_trunk);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (i == RodInventoryButtonTypes.BUTTON_HOUSE.ordinal()) {
            String string5 = context.getString(R.string.warehouse_home_wardrobe);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        } else if (i == RodInventoryButtonTypes.BUTTON_DRAWER.ordinal()) {
            String string6 = context.getString(R.string.warehouse_nightstand);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        } else if (i == RodInventoryButtonTypes.BUTTON_SHIP.ordinal()) {
            String string7 = context.getString(R.string.warehouse_ship);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        } else if (i == RodInventoryButtonTypes.BUTTON_CAMPER.ordinal()) {
            String string8 = context.getString(R.string.warehouse_motorhome);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        } else if (i == RodInventoryButtonTypes.BUTTON_BANK_VAULT.ordinal()) {
            String string9 = context.getString(R.string.warehouse_bank_vault);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        } else if (i == RodInventoryButtonTypes.BUTTON_FRACTION_WAREHOUSE.ordinal()) {
            String string10 = context.getString(R.string.warehouse_fraction);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        } else if (i == RodInventoryButtonTypes.BUTTON_FAMILY_WAREHOUSE.ordinal()) {
            String string11 = context.getString(R.string.warehouse_family);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        } else if (i == RodInventoryButtonTypes.BUTTON_GARDENING_BARN.ordinal()) {
            String string12 = context.getString(R.string.warehouse_barn);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        } else if (i == RodInventoryButtonTypes.BUTTON_GARAGE.ordinal()) {
            String string13 = context.getString(R.string.garage);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        } else if (i == RodInventoryButtonTypes.BUTTON_SECURITY.ordinal()) {
            String string14 = context.getString(R.string.security_guards);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        } else if (i == RodInventoryButtonTypes.BUTTON_CARS.ordinal()) {
            String string15 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        } else if (i == RodInventoryButtonTypes.BUTTON_BIZ.ordinal()) {
            String string16 = context.getString(R.string.my_businesses);
            Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
            return string16;
        } else if (i == RodInventoryButtonTypes.BUTTON_HOUSES.ordinal()) {
            String string17 = context.getString(R.string.my_houses);
            Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
            return string17;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRAILER.ordinal()) {
            String string18 = context.getString(R.string.trailer);
            Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
            return string18;
        } else if (i == RodInventoryButtonTypes.BUTTON_LABORATORY.ordinal()) {
            String string19 = context.getString(R.string.warehouse_laboratory);
            Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
            return string19;
        } else if (i == RodInventoryButtonTypes.BUTTON_WAREHOUSE_GARAGE.ordinal()) {
            String string20 = context.getString(R.string.garage);
            Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
            return string20;
        } else if (i == RodInventoryButtonTypes.BUTTON_LABORATORY_LOOT.ordinal()) {
            String string21 = context.getString(R.string.warehouse_laboratory_loot);
            Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
            return string21;
        } else {
            return "";
        }
    }

    public static final String getDeviceName() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String str2 = Build.MODEL;
        String str3 = str2 != null ? str2 : "";
        if (StringsKt.startsWith$default(str3, str, false, 2, (Object) null)) {
            return capitalize(str3);
        }
        return capitalize(str) + " " + str3;
    }

    private static final String capitalize(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return upperCase + substring;
    }

    public static final boolean getArizonaType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isArizonaType();
    }

    public static final ServerInfoItem getServerId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences baseShredPref = getBaseShredPref(context);
        int i = baseShredPref.getInt(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.SERVER_ID.getKeyName(), 0);
        String string = baseShredPref.getString(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.API_TOKEN.getKeyName(), "");
        return new ServerInfoItem(string != null ? string : "", i, baseShredPref.getInt(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.ACCOUNT_ID.getKeyName(), 0));
    }

    public static final String formatNumberWithSpaces(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.replace$default(format, StringUtils.COMMA, " ", false, 4, (Object) null);
    }

    public static final String formatTime(long j) {
        long j2 = j / 1000;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final void setColoredTextBeforeDot(TextView textView, String fullText, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(fullText, "fullText");
        String str = fullText;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            textView.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, indexOf$default, 33);
        textView.setText(spannableString);
    }

    public static final SharedPreferences getBaseShredPref(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences sharedPreferences = context.getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadGifFromZipAsync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$loadGifFromZipAsync$1 utilsKt$loadGifFromZipAsync$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$loadGifFromZipAsync$1) {
            utilsKt$loadGifFromZipAsync$1 = (UtilsKt$loadGifFromZipAsync$1) continuation;
            if ((utilsKt$loadGifFromZipAsync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$loadGifFromZipAsync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$loadGifFromZipAsync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$loadGifFromZipAsync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$loadGifFromZipAsync$1.L$0 = imageView;
                    utilsKt$loadGifFromZipAsync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$loadGifFromZipAsync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$loadGifFromZipAsync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$loadGifFromZipAsync$bytes$1(str, str2, null), utilsKt$loadGifFromZipAsync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$loadGifFromZipAsync$1.L$2;
                    String str4 = (String) utilsKt$loadGifFromZipAsync$1.L$1;
                    imageView = (ImageView) utilsKt$loadGifFromZipAsync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).asGif().load(bArr).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$loadGifFromZipAsync$1 = new UtilsKt$loadGifFromZipAsync$1(continuation);
        Object obj2 = utilsKt$loadGifFromZipAsync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$loadGifFromZipAsync$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    public static /* synthetic */ void gifLoadFromCdn$default(ImageView imageView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        gifLoadFromCdn(imageView, str, str2);
    }

    public static final void gifLoadFromCdn(ImageView imageView, String url, String fallbackImage) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
        ImageView imageView2 = imageView;
        RequestBuilder<Drawable> load = Glide.with(imageView2).load(fallbackImage);
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        Glide.with(imageView2).asGif().load(url).placeholder(R.drawable.loading_gif).error((Object) load).into(imageView);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object gifGetFromZipAcyncGif(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$gifGetFromZipAcyncGif$1 utilsKt$gifGetFromZipAcyncGif$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$gifGetFromZipAcyncGif$1) {
            utilsKt$gifGetFromZipAcyncGif$1 = (UtilsKt$gifGetFromZipAcyncGif$1) continuation;
            if ((utilsKt$gifGetFromZipAcyncGif$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$gifGetFromZipAcyncGif$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$gifGetFromZipAcyncGif$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$gifGetFromZipAcyncGif$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$gifGetFromZipAcyncGif$1.L$0 = imageView;
                    utilsKt$gifGetFromZipAcyncGif$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$gifGetFromZipAcyncGif$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$gifGetFromZipAcyncGif$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$gifGetFromZipAcyncGif$bytes$1(str, str2, null), utilsKt$gifGetFromZipAcyncGif$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$gifGetFromZipAcyncGif$1.L$2;
                    String str4 = (String) utilsKt$gifGetFromZipAcyncGif$1.L$1;
                    imageView = (ImageView) utilsKt$gifGetFromZipAcyncGif$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).asGif().load(bArr).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$gifGetFromZipAcyncGif$1 = new UtilsKt$gifGetFromZipAcyncGif$1(continuation);
        Object obj2 = utilsKt$gifGetFromZipAcyncGif$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$gifGetFromZipAcyncGif$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object gifGetFromZipAcync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$gifGetFromZipAcync$1 utilsKt$gifGetFromZipAcync$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$gifGetFromZipAcync$1) {
            utilsKt$gifGetFromZipAcync$1 = (UtilsKt$gifGetFromZipAcync$1) continuation;
            if ((utilsKt$gifGetFromZipAcync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$gifGetFromZipAcync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$gifGetFromZipAcync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$gifGetFromZipAcync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$gifGetFromZipAcync$1.L$0 = imageView;
                    utilsKt$gifGetFromZipAcync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$gifGetFromZipAcync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$gifGetFromZipAcync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$gifGetFromZipAcync$bytes$1(str, str2, null), utilsKt$gifGetFromZipAcync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$gifGetFromZipAcync$1.L$2;
                    String str4 = (String) utilsKt$gifGetFromZipAcync$1.L$1;
                    imageView = (ImageView) utilsKt$gifGetFromZipAcync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).load(bArr).dontAnimate().into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$gifGetFromZipAcync$1 = new UtilsKt$gifGetFromZipAcync$1(continuation);
        Object obj2 = utilsKt$gifGetFromZipAcync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$gifGetFromZipAcync$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setImageFromZipAcync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$setImageFromZipAcync$1 utilsKt$setImageFromZipAcync$1;
        int i;
        Bitmap bitmap;
        if (continuation instanceof UtilsKt$setImageFromZipAcync$1) {
            utilsKt$setImageFromZipAcync$1 = (UtilsKt$setImageFromZipAcync$1) continuation;
            if ((utilsKt$setImageFromZipAcync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$setImageFromZipAcync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$setImageFromZipAcync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$setImageFromZipAcync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$setImageFromZipAcync$1.L$0 = imageView;
                    utilsKt$setImageFromZipAcync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$setImageFromZipAcync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$setImageFromZipAcync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$setImageFromZipAcync$bytes$1(str, str2, null), utilsKt$setImageFromZipAcync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$setImageFromZipAcync$1.L$2;
                    String str4 = (String) utilsKt$setImageFromZipAcync$1.L$1;
                    imageView = (ImageView) utilsKt$setImageFromZipAcync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    return Unit.INSTANCE;
                }
                imageView.setImageBitmap(bitmap);
                return Unit.INSTANCE;
            }
        }
        utilsKt$setImageFromZipAcync$1 = new UtilsKt$setImageFromZipAcync$1(continuation);
        Object obj2 = utilsKt$setImageFromZipAcync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$setImageFromZipAcync$1.label;
        if (i != 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setImageFromArchive(ImageView imageView, String str, int i, Continuation<? super Unit> continuation) {
        UtilsKt$setImageFromArchive$1 utilsKt$setImageFromArchive$1;
        int i2;
        Bitmap bitmap;
        if (continuation instanceof UtilsKt$setImageFromArchive$1) {
            utilsKt$setImageFromArchive$1 = (UtilsKt$setImageFromArchive$1) continuation;
            if ((utilsKt$setImageFromArchive$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$setImageFromArchive$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$setImageFromArchive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = utilsKt$setImageFromArchive$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$setImageFromArchive$1.L$0 = imageView;
                    utilsKt$setImageFromArchive$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$setImageFromArchive$1.I$0 = i;
                    utilsKt$setImageFromArchive$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$setImageFromArchive$bitmap$1(str, i, null), utilsKt$setImageFromArchive$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = utilsKt$setImageFromArchive$1.I$0;
                    String str2 = (String) utilsKt$setImageFromArchive$1.L$1;
                    imageView = (ImageView) utilsKt$setImageFromArchive$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bitmap = (Bitmap) obj;
                if (bitmap == null) {
                    setImage(imageView, bitmap);
                } else {
                    Context context = imageView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    setNotLoadedImage(imageView, context);
                }
                return Unit.INSTANCE;
            }
        }
        utilsKt$setImageFromArchive$1 = new UtilsKt$setImageFromArchive$1(continuation);
        Object obj2 = utilsKt$setImageFromArchive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = utilsKt$setImageFromArchive$1.label;
        if (i2 != 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap == null) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object setImageFromArchive$default(ImageView imageView, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "items";
        }
        return setImageFromArchive(imageView, str, i, continuation);
    }
}

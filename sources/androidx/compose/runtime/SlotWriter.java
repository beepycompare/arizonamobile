package androidx.compose.runtime;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u0000 Ö\u00012\u00020\u0001:\u0002Ö\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00103\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010<\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010>\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u0016\u0010?\u001a\u00020/2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u0010C\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/J\u0006\u0010J\u001a\u00020HJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0014\u0010L\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010M\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u000e\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Q\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0006\u0010R\u001a\u00020HJ\u000e\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020UJ\u0016\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\u0006\u0010(\u001a\u00020UJ\u0006\u0010X\u001a\u00020HJ\u001c\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u0010C\u001a\u00020\u00192\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010Z\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0018\u0010Z\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010[\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\\\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u001d\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0086\bJ\u0016\u0010]\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\"\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010^\u001a\u0004\u0018\u00010\u00012\u0006\u0010_\u001a\u00020\u0019J\b\u0010`\u001a\u0004\u0018\u00010\u0001J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0019J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010b\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J5\u0010c\u001a\u00020H2\u0006\u0010b\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u001a\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJ\u0015\u0010f\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bkJ\u000e\u0010n\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020\u0019J\u000e\u0010q\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010r\u001a\u00020HJ\u0006\u0010s\u001a\u00020HJ\u0006\u0010t\u001a\u00020HJ\u0006\u0010u\u001a\u00020HJ\u000e\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u0019J\u0018\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010v\u001a\u0004\u0018\u00010\u0001J\u0018\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u0001J\"\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u0001J\"\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010z\u001a\u0004\u0018\u00010\u0001J\u0018\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010z\u001a\u0004\u0018\u00010\u0001J,\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020/2\b\u0010z\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010{\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010}\u001a\u00020\u0019J\u0006\u0010~\u001a\u00020/J\u000f\u0010\u007f\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0080\u0001JQ\u0010\u0081\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJb\u0010\u0085\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192&\u0010\u0086\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u00012&\u0010\u0089\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u0001H\u0086\bJN\u0010\u008a\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eJ\u0010\u0010\u008b\u0001\u001a\u00020H2\u0007\u0010\u008c\u0001\u001a\u00020\u0019J(\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u008e\u00012\u0006\u0010B\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u008f\u0001\u001a\u00020\u0000J)\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u008e\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00192\t\b\u0002\u0010\u0091\u0001\u001a\u00020/J\u0007\u0010\u0092\u0001\u001a\u00020HJ'\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u008e\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0019J\u0010\u0010B\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u0019J\u0011\u0010\u0094\u0001\u001a\u00020H2\b\b\u0002\u0010@\u001a\u00020\u0019J\u0011\u0010\u0095\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0011\u0010\u0096\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010\u009a\u0001\u001a\u00020HH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u0019H\u0002J#\u0010\u009c\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192\u0007\u0010\\\u001a\u00030\u0098\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u000f\u0010 \u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\t\u0010¡\u0001\u001a\u00020UH\u0016J\t\u0010¢\u0001\u001a\u00020HH\u0002J\t\u0010£\u0001\u001a\u00020\u0019H\u0002J\"\u0010¤\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010{\u001a\u00020\u00192\u0007\u0010¥\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010¦\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0019\u0010§\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010¨\u0001\u001a\u00020HH\u0002J\u0012\u0010©\u0001\u001a\u00020H2\u0007\u0010ª\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010«\u0001\u001a\u00020H2\u0007\u0010ª\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010¬\u0001\u001a\u00020/2\u0007\u0010\u00ad\u0001\u001a\u00020\u00192\u0007\u0010®\u0001\u001a\u00020\u0019H\u0002J\u0019\u0010¯\u0001\u001a\u0004\u0018\u00010\u00132\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b°\u0001J\u0019\u0010±\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b²\u0001J#\u0010³\u0001\u001a\u00020H2\u0007\u0010\u00ad\u0001\u001a\u00020\u00192\u0007\u0010®\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010´\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010µ\u0001\u001a\u00020H2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010·\u0001\u001a\u00020\u0019H\u0002JC\u0010¸\u0001\u001a\u00020/2\u0007\u0010¹\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u00192&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002J$\u0010º\u0001\u001a\u00020H2\u0007\u0010»\u0001\u001a\u00020\u00192\u0007\u0010¼\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010½\u0001\u001a\u00020UJ\u001b\u0010¾\u0001\u001a\u00020H*\b0¿\u0001j\u0003`À\u00012\u0006\u00108\u001a\u00020\u0019H\u0002J\u000f\u0010Á\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÂ\u0001J\u000f\u0010Ã\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÄ\u0001J\u0011\u0010È\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0012\u0010É\u0001\u001a\u00020\u00192\u0007\u0010Ê\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010C\u001a\u00020\u0019*\u00020\t2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0011\u0010Ê\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0016\u0010Ê\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u0019H\u0002J\u0015\u0010_\u001a\u00020\u0019*\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u0019H\u0002J\u001f\u0010Ì\u0001\u001a\u00020H*\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u00192\u0007\u0010Ê\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Í\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Î\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u008e\u0001*\u00020\tH\u0002J\u0010\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u008e\u0001H\u0002J,\u0010Ñ\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u00192\u0007\u0010Ò\u0001\u001a\u00020\u00192\u0007\u0010Æ\u0001\u001a\u00020\u0019H\u0002J#\u0010Ó\u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\u0007\u0010Ò\u0001\u001a\u00020\u00192\u0007\u0010Æ\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010Ô\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010Õ\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b.\u00100R\u0011\u00101\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b2\u0010+R\u0011\u00103\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b3\u00100R\u0011\u00104\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b5\u00100R\u0011\u00106\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b7\u00100R\u001e\u0010C\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u001e\u0010E\u001a\u00020/2\u0006\u0010(\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0014\u0010l\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010+R\u0015\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0099\u0001R\u0016\u0010ª\u0001\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010+R\u0016\u0010Æ\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010+¨\u0006×\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "", "slots", "", "[Ljava/lang/Object;", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "groupGapStart", "", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "nodeCount", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "value", "currentGroup", "getCurrentGroup", "()I", "currentGroupEnd", "getCurrentGroupEnd", "isGroupEnd", "", "()Z", "slotsSize", "getSlotsSize", "isNode", "collectingSourceInformation", "getCollectingSourceInformation", "collectingCalledInformation", "getCollectingCalledInformation", FirebaseAnalytics.Param.INDEX, "groupKey", "groupObjectKey", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "group", "node", "anchor", "parent", "getParent", "closed", "getClosed", "close", "", "normalClose", "reset", "update", "rawUpdate", "appendSlot", "trimTailSlots", "count", "updateAux", "insertAux", "updateToTableMaps", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "key", "recordGrouplessCallSourceInformationEnd", "groupSourceInformationFor", "updateNode", "updateParentNode", "set", "slotIndexOfGroupSlotIndex", "clear", "slotIndex", "skip", "slot", "groupIndex", "forEachTailSlot", "block", "Lkotlin/Function2;", "slotsStartIndex", "slotsStartIndex$runtime", "slotsEndIndex", "slotsEndIndex$runtime", "slotsEndAllIndex", "slotsEndAllIndex$runtime", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "groupSlotIndex", "advanceBy", "amount", "seek", "skipToGroupEnd", "beginInsert", "endInsert", "startGroup", "dataKey", "startNode", "objectKey", "startData", "aux", "endGroup", "ensureStarted", "skipGroup", "removeGroup", "groupSlots", "", "forAllData", "Lkotlin/ParameterName;", "name", "data", "traverseGroupAndChildren", "enter", "Lkotlin/Function1;", "child", "exit", "forAllDataInRememberOrder", "moveGroup", TypedValues.CycleType.S_WAVE_OFFSET, "moveTo", "", "writer", "moveFrom", "removeSourceGroup", "bashCurrentGroup", "moveIntoGroupFrom", "markGroup", "containsGroupMark", "containsAnyGroupMarks", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "Landroidx/collection/MutableIntList;", "recalculateMarks", "updateContainsMark", "updateContainsMarkNow", "updateContainsMarkNow-XpTMRCE", "(ILandroidx/collection/MutableIntList;)V", "childContainsAnyMarks", "anchorIndex", "toString", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "fixParentAnchorsFor", "firstChild", "moveGroupGapTo", "moveSlotGapTo", "clearSlotGap", "insertGroups", "size", "insertSlots", "removeGroups", TtmlNode.START, "len", "sourceInformationOf", "sourceInformationOf$runtime", "tryAnchor", "tryAnchor$runtime", "removeSlots", "updateNodeOfGroup", "updateAnchors", "previousGapStart", "newGapStart", "removeAnchors", "gapStart", "moveAnchors", "originalLocation", "newLocation", "toDebugString", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "verifyDataAnchors", "verifyDataAnchors$runtime", "verifyParentAnchors", "verifyParentAnchors$runtime", "getSize$runtime", "capacity", "getCapacity", "groupIndexToAddress", "dataIndexToDataAddress", "dataIndex", "address", "updateDataIndex", "nodeIndex", "auxIndex", "dataIndexes", UserMetadata.KEYDATA_FILENAME, "dataIndexToDataAnchor", "gapLen", "dataAnchorToDataIndex", "parentIndexToAnchor", "parentAnchorToIndex", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private MutableIntList pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startStack = new IntStack();
    private final IntStack endStack = new IntStack();
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    private final int dataAnchorToDataIndex(int i, int i2, int i3) {
        return i < 0 ? (i3 - i2) + i + 1 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime();
        this.calledByMap = slotTable.getCalledByMap$runtime();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    public final SlotTable getTable$runtime() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && (this.groups[(groupIndexToAddress(i) * 5) + 1] & 1073741824) != 0;
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean isNode(int i) {
        return (this.groups[(groupIndexToAddress(i) * 5) + 1] & 1073741824) != 0;
    }

    public final int nodeCount(int i) {
        return this.groups[(groupIndexToAddress(i) * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int groupKey(int i) {
        return this.groups[groupIndexToAddress(i) * 5];
    }

    public final Object groupObjectKey(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if ((iArr[(groupIndexToAddress * 5) + 1] & C.BUFFER_FLAG_LAST_SAMPLE) != 0) {
            return this.slots[SlotTableKt.access$objectKeyIndex(iArr, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i));
    }

    public final Object groupAux(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        return (iArr[(groupIndexToAddress * 5) + 1] & 268435456) != 0 ? this.slots[auxIndex(iArr, groupIndexToAddress)] : Composer.Companion.getEmpty();
    }

    public final boolean indexInParent(int i) {
        int i2 = this.parent;
        if (i <= i2 || i >= this.currentGroupEnd) {
            return i2 == 0 && i == 0;
        }
        return true;
    }

    public final boolean indexInCurrentGroup(int i) {
        return indexInGroup(i, this.currentGroup);
    }

    public final boolean indexInGroup(int i, int i2) {
        int capacity;
        int groupSize;
        if (i2 == this.parent) {
            capacity = this.currentGroupEnd;
        } else {
            if (i2 > this.startStack.peekOr(0)) {
                groupSize = groupSize(i2);
            } else {
                int indexOf = this.startStack.indexOf(i2);
                if (indexOf < 0) {
                    groupSize = groupSize(i2);
                } else {
                    capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            capacity = groupSize + i2;
        }
        return i > i2 && i < capacity;
    }

    public final Object node(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if ((iArr[(groupIndexToAddress * 5) + 1] & 1073741824) != 0) {
            return this.slots[dataIndexToDataAddress(nodeIndex(iArr, groupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int i) {
        return parent(this.groups, i);
    }

    public final int parent(Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close(boolean z) {
        this.closed = true;
        if (z && this.startStack.tos == 0) {
            moveGroupGapTo(getSize$runtime());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final Object update(Object obj) {
        if (this.insertCount > 0 && this.currentSlot != this.slotsGapStart) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap == null) {
                mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            }
            this.deferredSlotWrites = mutableIntObjectMap;
            int i = this.parent;
            MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i);
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(0, 1, null);
                mutableIntObjectMap.set(i, mutableObjectList);
            }
            mutableObjectList.add(obj);
            return Composer.Companion.getEmpty();
        }
        return rawUpdate(obj);
    }

    private final Object rawUpdate(Object obj) {
        Object skip = skip();
        set(obj);
        return skip;
    }

    public final void appendSlot(Anchor anchor, Object obj) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i2 = this.currentSlotEnd;
        int anchorIndex = anchorIndex(anchor);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(anchorIndex + 1));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
        insertSlots(1, anchorIndex);
        if (i >= dataIndex) {
            i++;
            i2++;
        }
        this.slots[dataIndex] = obj;
        this.currentSlot = i;
        this.currentSlotEnd = i2;
    }

    public final void updateAux(Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!((this.groups[(groupIndexToAddress * 5) + 1] & 268435456) != 0)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
    }

    public final void insertAux(Object obj) {
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int i = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i);
        if ((this.groups[(groupIndexToAddress * 5) + 1] & 268435456) != 0) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(1, i);
        int auxIndex = auxIndex(this.groups, groupIndexToAddress);
        int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
        int i2 = this.currentSlot;
        if (i2 > auxIndex) {
            int i3 = i2 - auxIndex;
            if (!(i3 < 3)) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (i3 > 1) {
                Object[] objArr = this.slots;
                objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
        }
        SlotTableKt.access$addAux(this.groups, groupIndexToAddress);
        this.slots[dataIndexToDataAddress] = obj;
        this.currentSlot++;
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime();
        this.calledByMap = this.table.getCalledByMap$runtime();
    }

    public final void recordGroupSourceInformation(String str) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, str);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int i, String str) {
        if (this.insertCount > 0) {
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            if (mutableIntObjectMap != null) {
                SlotTableKt.access$add(mutableIntObjectMap, i, groupKey(this.parent));
            }
            GroupSourceInformation groupSourceInformationFor = groupSourceInformationFor(this.parent, null);
            if (groupSourceInformationFor != null) {
                groupSourceInformationFor.startGrouplessCall(i, str, getCurrentGroupSlotIndex());
            }
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        GroupSourceInformation groupSourceInformationFor;
        if (this.insertCount <= 0 || (groupSourceInformationFor = groupSourceInformationFor(this.parent, null)) == null) {
            return;
        }
        groupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
    }

    private final GroupSourceInformation groupSourceInformationFor(int i, String str) {
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap != null) {
            HashMap<Anchor, GroupSourceInformation> hashMap2 = hashMap;
            Anchor anchor = anchor(i);
            GroupSourceInformation groupSourceInformation = hashMap2.get(anchor);
            if (groupSourceInformation == null) {
                groupSourceInformation = new GroupSourceInformation(0, str, 0);
                if (str == null) {
                    int i2 = i + 1;
                    int i3 = this.currentGroup;
                    while (i2 < i3) {
                        groupSourceInformation.reportGroup(this, i2);
                        i2 += SlotTableKt.access$groupSize(this.groups, i2);
                    }
                }
                hashMap2.put(anchor, groupSourceInformation);
            }
            return groupSourceInformation;
        }
        return null;
    }

    public final void updateNode(Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateNode(Anchor anchor, Object obj) {
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    public final void updateParentNode(Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void set(Object obj) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = obj;
    }

    public final Object set(int i, Object obj) {
        return set(getCurrentGroup(), i, obj);
    }

    public final int slotIndexOfGroupSlotIndex(int i, int i2) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int i3 = slotIndex + i2;
        if (!(i3 >= slotIndex && i3 < dataIndex(this.groups, groupIndexToAddress(i + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + i2 + " for group " + i);
        }
        return i3;
    }

    public final Object set(int i, int i2, Object obj) {
        int dataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(i, i2));
        Object[] objArr = this.slots;
        Object obj2 = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = obj;
        return obj2;
    }

    public final Object clear(int i) {
        int dataIndexToDataAddress = dataIndexToDataAddress(i);
        Object[] objArr = this.slots;
        Object obj = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = Composer.Companion.getEmpty();
        return obj;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int i) {
        return slot(anchorIndex(anchor), i);
    }

    public final Object slot(int i, int i2) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        int i3 = i2 + slotIndex;
        if (slotIndex > i3 || i3 >= dataIndex) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i3)];
    }

    public final void forEachTailSlot(int i, int i2, Function2<? super Integer, Object, Unit> function2) {
        int slotsStartIndex$runtime = slotsStartIndex$runtime(i);
        int slotsEndIndex$runtime = slotsEndIndex$runtime(i);
        for (int max = Math.max(slotsStartIndex$runtime, slotsEndIndex$runtime - i2); max < slotsEndIndex$runtime; max++) {
            function2.invoke(Integer.valueOf(max), this.slots[dataIndexToDataAddress(max)]);
        }
    }

    public final int slotsStartIndex$runtime(int i) {
        return slotIndex(this.groups, groupIndexToAddress(i));
    }

    public final int slotsEndIndex$runtime(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i + 1));
    }

    public final int slotsEndAllIndex$runtime(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i + groupSize(i)));
    }

    private final int getCurrentGroupSlotIndex() {
        return groupSlotIndex(this.parent);
    }

    public final int groupSlotIndex(int i) {
        MutableObjectList<Object> mutableObjectList;
        int slotsStartIndex$runtime = this.currentSlot - slotsStartIndex$runtime(i);
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        return slotsStartIndex$runtime + ((mutableIntObjectMap == null || (mutableObjectList = mutableIntObjectMap.get(i)) == null) ? 0 : mutableObjectList.getSize());
    }

    public final void advanceBy(int i) {
        boolean z = true;
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.currentGroup + i;
        if (i2 < this.parent || i2 > this.currentGroupEnd) {
            z = false;
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }
        this.currentGroup = i2;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
    }

    public final void seek(Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (!(this.nodeCountStack.tos == this.startStack.tos)) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i) {
        startGroup(i, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i, Object obj) {
        startGroup(i, obj, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj) {
        startGroup(i, obj, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj, Object obj2) {
        startGroup(i, obj, true, obj2);
    }

    public final void startData(int i, Object obj, Object obj2) {
        startGroup(i, obj, false, obj2);
    }

    public final void startData(int i, Object obj) {
        startGroup(i, Composer.Companion.getEmpty(), false, obj);
    }

    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private final void startGroup(int i, Object obj, boolean z, Object obj2) {
        int access$groupSize;
        GroupSourceInformation sourceInformationOf$runtime;
        int i2 = this.parent;
        Object[] objArr = this.insertCount > 0 ? 1 : null;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != null) {
            int i3 = this.currentGroup;
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(i3));
            insertGroups(1);
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
            int groupIndexToAddress = groupIndexToAddress(i3);
            ?? r12 = obj != Composer.Companion.getEmpty() ? 1 : 0;
            ?? r13 = (z || obj2 == Composer.Companion.getEmpty()) ? 0 : 1;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (dataIndexToDataAnchor >= 0 && this.slotsGapOwner < i3) {
                dataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - dataIndexToDataAnchor) + 1);
            }
            SlotTableKt.access$initGroup(this.groups, groupIndexToAddress, i, z, r12, r13, this.parent, dataIndexToDataAnchor);
            int i4 = (z ? 1 : 0) + r12 + r13;
            if (i4 > 0) {
                insertSlots(i4, i3);
                Object[] objArr2 = this.slots;
                int i5 = this.currentSlot;
                if (z) {
                    objArr2[i5] = obj2;
                    i5++;
                }
                if (r12 != 0) {
                    objArr2[i5] = obj;
                    i5++;
                }
                if (r13 != 0) {
                    objArr2[i5] = obj2;
                    i5++;
                }
                this.currentSlot = i5;
            }
            this.nodeCount = 0;
            access$groupSize = i3 + 1;
            this.parent = i3;
            this.currentGroup = access$groupSize;
            if (i2 >= 0 && (sourceInformationOf$runtime = sourceInformationOf$runtime(i2)) != null) {
                sourceInformationOf$runtime.reportGroup(this, i3);
            }
        } else {
            this.startStack.push(i2);
            saveCurrentGroupEnd();
            int i6 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i6);
            if (!Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                if (z) {
                    updateNode(obj2);
                } else {
                    updateAux(obj2);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            int[] iArr = this.groups;
            this.nodeCount = iArr[(groupIndexToAddress2 * 5) + 1] & RectListKt.Lower26Bits;
            this.parent = i6;
            this.currentGroup = i6 + 1;
            access$groupSize = i6 + SlotTableKt.access$groupSize(iArr, groupIndexToAddress2);
        }
        this.currentGroupEnd = access$groupSize;
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z = this.insertCount > 0;
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int i3 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i3);
        int i4 = this.nodeCount;
        int i5 = i - i3;
        int i6 = (groupIndexToAddress * 5) + 1;
        boolean z2 = (this.groups[i6] & 1073741824) != 0;
        if (z) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i3)) != null) {
                MutableObjectList<Object> mutableObjectList2 = mutableObjectList;
                Object[] objArr = mutableObjectList2.content;
                int i7 = mutableObjectList2._size;
                for (int i8 = 0; i8 < i7; i8++) {
                    rawUpdate(objArr[i8]);
                }
                mutableIntObjectMap.remove(i3);
            }
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, i5);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i4);
            this.nodeCount = this.nodeCountStack.pop() + (z2 ? 1 : i4);
            int parent = parent(this.groups, i3);
            this.parent = parent;
            int size$runtime = parent < 0 ? getSize$runtime() : groupIndexToAddress(parent + 1);
            int dataIndex = size$runtime >= 0 ? dataIndex(this.groups, size$runtime) : 0;
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
            return i4;
        }
        if (!(i == i2)) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
        int[] iArr = this.groups;
        int i9 = iArr[i6] & RectListKt.Lower26Bits;
        SlotTableKt.access$updateGroupSize(iArr, groupIndexToAddress, i5);
        SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i4);
        int pop = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = pop;
        int parent2 = parent(this.groups, i3);
        int pop2 = this.nodeCountStack.pop();
        this.nodeCount = pop2;
        if (parent2 == pop) {
            this.nodeCount = pop2 + (z2 ? 0 : i4 - i9);
            return i4;
        }
        int i10 = i5 - access$groupSize;
        int i11 = z2 ? 0 : i4 - i9;
        if (i10 != 0 || i11 != 0) {
            while (parent2 != 0 && parent2 != pop && (i11 != 0 || i10 != 0)) {
                int groupIndexToAddress2 = groupIndexToAddress(parent2);
                if (i10 != 0) {
                    SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2) + i10);
                }
                if (i11 != 0) {
                    int[] iArr2 = this.groups;
                    SlotTableKt.access$updateNodeCount(iArr2, groupIndexToAddress2, (iArr2[(groupIndexToAddress2 * 5) + 1] & RectListKt.Lower26Bits) + i11);
                }
                int[] iArr3 = this.groups;
                if ((iArr3[(groupIndexToAddress2 * 5) + 1] & 1073741824) != 0) {
                    i11 = 0;
                }
                parent2 = parent(iArr3, parent2);
            }
        }
        this.nodeCount += i11;
        return i4;
    }

    public final void ensureStarted(int i) {
        boolean z = true;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i2 = this.parent;
        if (i2 != i) {
            if (i < i2 || i >= this.currentGroupEnd) {
                z = false;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + i + " must be a subgroup of the group at " + i2);
            }
            int i3 = this.currentGroup;
            int i4 = this.currentSlot;
            int i5 = this.currentSlotEnd;
            this.currentGroup = i;
            startGroup();
            this.currentGroup = i3;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
        }
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        int i = this.groups[(groupIndexToAddress * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & RectListKt.Lower26Bits;
    }

    public final boolean removeGroup() {
        Anchor tryAnchor$runtime;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int skipGroup = skipGroup();
        GroupSourceInformation sourceInformationOf$runtime = sourceInformationOf$runtime(this.parent);
        if (sourceInformationOf$runtime != null && (tryAnchor$runtime = tryAnchor$runtime(i)) != null) {
            sourceInformationOf$runtime.removeAnchor(tryAnchor$runtime);
        }
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m3825isNotEmptyimpl(mutableIntList) && PrioritySet.m3826peekimpl(mutableIntList) >= i) {
                PrioritySet.m3827takeMaximpl(mutableIntList);
            }
        }
        boolean removeGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(dataIndex, this.currentSlot - dataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= skipGroup;
        return removeGroups;
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    public final void forAllData(int i, Function2<? super Integer, Object, Unit> function2) {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(getCurrentGroup() + groupSize(getCurrentGroup())));
        for (int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i)); dataIndex2 < dataIndex; dataIndex2++) {
            function2.invoke(Integer.valueOf(dataIndex2), this.slots[dataIndexToDataAddress(dataIndex2)]);
        }
    }

    public final void traverseGroupAndChildren(int i, Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12) {
        int parent = parent(i);
        int size$runtime = getSize$runtime();
        int groupSize = groupSize(i) + i;
        int i2 = i;
        while (i2 < groupSize) {
            function1.invoke(Integer.valueOf(i2));
            int i3 = i2 + 1;
            int parent2 = i3 < size$runtime ? parent(i3) : -1;
            if (parent2 != i2) {
                while (true) {
                    function12.invoke(Integer.valueOf(i2));
                    if (i2 != i && parent != parent2) {
                        i2 = parent;
                        parent = parent(parent);
                    }
                }
            }
            i2 = i3;
            parent = parent2;
        }
    }

    public final void moveGroup(int i) {
        boolean z = true;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.currentGroup;
        int i3 = this.parent;
        int i4 = this.currentGroupEnd;
        int i5 = i2;
        for (int i6 = i; i6 > 0; i6--) {
            i5 += SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i5));
            if (!(i5 <= i4)) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i5));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i5));
        int i7 = i5 + access$groupSize;
        int dataIndex3 = dataIndex(this.groups, groupIndexToAddress(i7));
        int i8 = dataIndex3 - dataIndex2;
        insertSlots(i8, Math.max(this.currentGroup - 1, 0));
        insertGroups(access$groupSize);
        int[] iArr = this.groups;
        int groupIndexToAddress = groupIndexToAddress(i7) * 5;
        ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i2) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
        if (i8 > 0) {
            Object[] objArr = this.slots;
            int dataIndexToDataAddress = dataIndexToDataAddress(dataIndex2 + i8);
            System.arraycopy(objArr, dataIndexToDataAddress, objArr, dataIndex, dataIndexToDataAddress(dataIndex3 + i8) - dataIndexToDataAddress);
        }
        int i9 = dataIndex2 + i8;
        int i10 = i9 - dataIndex;
        int i11 = this.slotsGapStart;
        int i12 = this.slotsGapLen;
        int length = this.slots.length;
        int i13 = this.slotsGapOwner;
        int i14 = i2 + access$groupSize;
        int i15 = i2;
        while (i15 < i14) {
            boolean z2 = z;
            int groupIndexToAddress2 = groupIndexToAddress(i15);
            int i16 = i15;
            int i17 = i10;
            updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i10, i13 < groupIndexToAddress2 ? 0 : i11, i12, length));
            i15 = i16 + 1;
            z = z2;
            i10 = i17;
        }
        moveAnchors(i7, i2, access$groupSize);
        if (removeGroups(i7, access$groupSize)) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i3, this.currentGroupEnd, i2);
        if (i8 > 0) {
            removeSlots(i9, i8, i7 - 1);
        }
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "<init>", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3) {
            boolean z4;
            ArrayList emptyList;
            int groupSize = slotWriter.groupSize(i);
            int i2 = i + groupSize;
            int dataIndex = slotWriter.dataIndex(i);
            int dataIndex2 = slotWriter.dataIndex(i2);
            int i3 = dataIndex2 - dataIndex;
            boolean containsAnyGroupMarks = slotWriter.containsAnyGroupMarks(i);
            slotWriter2.insertGroups(groupSize);
            slotWriter2.insertSlots(i3, slotWriter2.getCurrentGroup());
            if (slotWriter.groupGapStart < i2) {
                slotWriter.moveGroupGapTo(i2);
            }
            if (slotWriter.slotsGapStart < dataIndex2) {
                slotWriter.moveSlotGapTo(dataIndex2, i2);
            }
            int[] iArr = slotWriter2.groups;
            int currentGroup = slotWriter2.getCurrentGroup();
            int i4 = currentGroup * 5;
            ArraysKt.copyInto(slotWriter.groups, iArr, i4, i * 5, i2 * 5);
            Object[] objArr = slotWriter2.slots;
            int i5 = slotWriter2.currentSlot;
            System.arraycopy(slotWriter.slots, dataIndex, objArr, i5, i3);
            int parent = slotWriter2.getParent();
            iArr[i4 + 2] = parent;
            int i6 = currentGroup - i;
            int i7 = currentGroup + groupSize;
            int dataIndex3 = i5 - slotWriter2.dataIndex(iArr, currentGroup);
            int i8 = slotWriter2.slotsGapOwner;
            int i9 = slotWriter2.slotsGapLen;
            int length = objArr.length;
            int i10 = i8;
            int i11 = currentGroup;
            while (true) {
                z4 = false;
                if (i11 >= i7) {
                    break;
                }
                if (i11 != currentGroup) {
                    int i12 = (i11 * 5) + 2;
                    iArr[i12] = iArr[i12] + i6;
                }
                int[] iArr2 = iArr;
                int i13 = currentGroup;
                iArr2[(i11 * 5) + 4] = slotWriter2.dataIndexToDataAnchor(slotWriter2.dataIndex(iArr, i11) + dataIndex3, i10 >= i11 ? slotWriter2.slotsGapStart : 0, i9, length);
                if (i11 == i10) {
                    i10++;
                }
                i11++;
                currentGroup = i13;
                iArr = iArr2;
            }
            int[] iArr3 = iArr;
            slotWriter2.slotsGapOwner = i10;
            int access$locationOf = SlotTableKt.access$locationOf(slotWriter.anchors, i, slotWriter.getSize$runtime());
            int access$locationOf2 = SlotTableKt.access$locationOf(slotWriter.anchors, i2, slotWriter.getSize$runtime());
            if (access$locationOf < access$locationOf2) {
                ArrayList arrayList = slotWriter.anchors;
                ArrayList arrayList2 = new ArrayList(access$locationOf2 - access$locationOf);
                for (int i14 = access$locationOf; i14 < access$locationOf2; i14++) {
                    Anchor anchor = (Anchor) arrayList.get(i14);
                    anchor.setLocation$runtime(anchor.getLocation$runtime() + i6);
                    arrayList2.add(anchor);
                }
                slotWriter2.anchors.addAll(SlotTableKt.access$locationOf(slotWriter2.anchors, slotWriter2.getCurrentGroup(), slotWriter2.getSize$runtime()), arrayList2);
                arrayList.subList(access$locationOf, access$locationOf2).clear();
                emptyList = arrayList2;
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            List<Anchor> list = emptyList;
            if (!list.isEmpty()) {
                HashMap hashMap = slotWriter.sourceInformationMap;
                HashMap hashMap2 = slotWriter2.sourceInformationMap;
                if (hashMap != null && hashMap2 != null) {
                    int size = list.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        Anchor anchor2 = emptyList.get(i15);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) hashMap.get(anchor2);
                        if (groupSourceInformation != null) {
                            hashMap.remove(anchor2);
                            hashMap2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int parent2 = slotWriter2.getParent();
            GroupSourceInformation sourceInformationOf$runtime = slotWriter2.sourceInformationOf$runtime(parent);
            if (sourceInformationOf$runtime != null) {
                int i16 = parent2 + 1;
                int currentGroup2 = slotWriter2.getCurrentGroup();
                int i17 = -1;
                while (i16 < currentGroup2) {
                    i17 = i16;
                    i16 = SlotTableKt.access$groupSize(slotWriter2.groups, i16) + i16;
                }
                sourceInformationOf$runtime.addGroupAfter(slotWriter2, i17, currentGroup2);
            }
            int parent3 = slotWriter.parent(i);
            if (z3) {
                if (!z) {
                    z4 = slotWriter.removeGroups(i, groupSize);
                    slotWriter.removeSlots(dataIndex, i3, i - 1);
                } else {
                    Object[] objArr2 = parent3 >= 0 ? 1 : null;
                    if (objArr2 != null) {
                        slotWriter.startGroup();
                        slotWriter.advanceBy(parent3 - slotWriter.getCurrentGroup());
                        slotWriter.startGroup();
                    }
                    slotWriter.advanceBy(i - slotWriter.getCurrentGroup());
                    boolean removeGroup = slotWriter.removeGroup();
                    if (objArr2 != null) {
                        slotWriter.skipToGroupEnd();
                        slotWriter.endGroup();
                        slotWriter.skipToGroupEnd();
                        slotWriter.endGroup();
                    }
                    z4 = removeGroup;
                }
            }
            if (z4) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            int i18 = slotWriter2.nodeCount;
            int i19 = iArr3[i4 + 1];
            slotWriter2.nodeCount = i18 + ((1073741824 & i19) == 0 ? i19 & RectListKt.Lower26Bits : 1);
            if (z2) {
                slotWriter2.currentGroup = i7;
                slotWriter2.currentSlot = i5 + i3;
            }
            if (containsAnyGroupMarks) {
                slotWriter2.updateContainsMark(parent);
            }
            return emptyList;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int i, SlotWriter slotWriter) {
        if (!(slotWriter.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!anchor.getValid()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int anchorIndex = anchorIndex(anchor) + i;
        int i2 = this.currentGroup;
        if (!(i2 <= anchorIndex && anchorIndex < this.currentGroupEnd)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int parent = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        int nodeCount = isNode(anchorIndex) ? 1 : nodeCount(anchorIndex);
        List<Anchor> moveGroup$default = Companion.moveGroup$default(Companion, this, anchorIndex, slotWriter, false, false, false, 32, null);
        updateContainsMark(parent);
        boolean z = nodeCount > 0;
        while (parent >= i2) {
            int groupIndexToAddress = groupIndexToAddress(parent);
            int[] iArr = this.groups;
            SlotTableKt.access$updateGroupSize(iArr, groupIndexToAddress, SlotTableKt.access$groupSize(iArr, groupIndexToAddress) - groupSize);
            if (z) {
                int[] iArr2 = this.groups;
                int i3 = iArr2[(groupIndexToAddress * 5) + 1];
                if ((1073741824 & i3) != 0) {
                    z = false;
                } else {
                    SlotTableKt.access$updateNodeCount(iArr2, groupIndexToAddress, (i3 & RectListKt.Lower26Bits) - nodeCount);
                }
            }
            parent = parent(parent);
        }
        if (z) {
            if (!(this.nodeCount >= nodeCount)) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            this.nodeCount -= nodeCount;
        }
        return moveGroup$default;
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return slotWriter.moveFrom(slotTable, i, z);
    }

    public final List<Anchor> moveFrom(SlotTable slotTable, int i, boolean z) {
        if (!(this.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (i == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0 && SlotTableKt.access$groupSize(slotTable.getGroups(), i) == slotTable.getGroupsSize()) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            int[] groups = slotTable.getGroups();
            int groupsSize = slotTable.getGroupsSize();
            Object[] slots = slotTable.getSlots();
            int slotsSize = slotTable.getSlotsSize();
            HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime = slotTable.getSourceInformationMap$runtime();
            MutableIntObjectMap<MutableIntSet> calledByMap$runtime = slotTable.getCalledByMap$runtime();
            this.groups = groups;
            this.slots = slots;
            this.anchors = slotTable.getAnchors$runtime();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            this.sourceInformationMap = sourceInformationMap$runtime;
            this.calledByMap = calledByMap$runtime;
            slotTable.setTo$runtime(iArr, 0, objArr, 0, arrayList, hashMap, mutableIntObjectMap);
            return this.anchors;
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            List<Anchor> moveGroup = Companion.moveGroup(openWriter, i, this, true, true, z);
            openWriter.close(true);
            return moveGroup;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public final void bashCurrentGroup() {
        SlotTableKt.access$updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final List<Anchor> moveIntoGroupFrom(int i, SlotTable slotTable, int i2) {
        if (!(this.insertCount <= 0 && groupSize(this.currentGroup + i) == 1)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i3 = this.currentGroup;
        int i4 = this.currentSlot;
        int i5 = this.currentSlotEnd;
        advanceBy(i);
        startGroup();
        beginInsert();
        SlotWriter openWriter = slotTable.openWriter();
        try {
            List<Anchor> moveGroup$default = Companion.moveGroup$default(Companion, openWriter, i2, this, false, true, false, 32, null);
            openWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i3;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
            return moveGroup$default;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int i) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.access$search(arrayList, i, getSize$runtime());
        if (access$search < 0) {
            if (i > this.groupGapStart) {
                i = -(getSize$runtime() - i);
            }
            Anchor anchor = new Anchor(i);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
        return arrayList.get(access$search);
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        int i2 = (groupIndexToAddress * 5) + 1;
        if ((iArr[i2] & C.BUFFER_FLAG_FIRST_SAMPLE) != 0) {
            return;
        }
        SlotTableKt.access$updateMark(iArr, groupIndexToAddress, true);
        if ((this.groups[i2] & 67108864) != 0) {
            return;
        }
        updateContainsMark(parent(i));
    }

    private final boolean containsGroupMark(int i) {
        return i >= 0 && (this.groups[(groupIndexToAddress(i) * 5) + 1] & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int i) {
        return i >= 0 && (this.groups[(groupIndexToAddress(i) * 5) + 1] & 201326592) != 0;
    }

    private final void recalculateMarks() {
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m3825isNotEmptyimpl(mutableIntList)) {
                m3845updateContainsMarkNowXpTMRCE(PrioritySet.m3827takeMaximpl(mutableIntList), mutableIntList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainsMark(int i) {
        if (i >= 0) {
            MutableIntList mutableIntList = this.pendingRecalculateMarks;
            if (mutableIntList == null) {
                mutableIntList = PrioritySet.m3820constructorimpl$default(null, 1, null);
                this.pendingRecalculateMarks = mutableIntList;
            }
            PrioritySet.m3817addimpl(mutableIntList, i);
        }
    }

    /* renamed from: updateContainsMarkNow-XpTMRCE  reason: not valid java name */
    private final void m3845updateContainsMarkNowXpTMRCE(int i, MutableIntList mutableIntList) {
        int groupIndexToAddress = groupIndexToAddress(i);
        boolean childContainsAnyMarks = childContainsAnyMarks(i);
        int[] iArr = this.groups;
        if (((iArr[(groupIndexToAddress * 5) + 1] & 67108864) != 0) != childContainsAnyMarks) {
            SlotTableKt.access$updateContainsMark(iArr, groupIndexToAddress, childContainsAnyMarks);
            int parent = parent(i);
            if (parent >= 0) {
                PrioritySet.m3817addimpl(mutableIntList, parent);
            }
        }
    }

    private final boolean childContainsAnyMarks(int i) {
        int i2 = i + 1;
        int groupSize = i + groupSize(i);
        while (i2 < groupSize) {
            if ((this.groups[(groupIndexToAddress(i2) * 5) + 1] & 201326592) != 0) {
                return true;
            }
            i2 += groupSize(i2);
        }
        return false;
    }

    public final int anchorIndex(Anchor anchor) {
        int location$runtime = anchor.getLocation$runtime();
        return location$runtime < 0 ? getSize$runtime() + location$runtime : location$runtime;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int i, int i2, int i3) {
        int parentIndexToAnchor = parentIndexToAnchor(i, this.groupGapStart);
        while (i3 < i2) {
            this.groups[(groupIndexToAddress(i3) * 5) + 2] = parentIndexToAnchor;
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i3)) + i3;
            fixParentAnchorsFor(i3, access$groupSize, i3 + 1);
            i3 = access$groupSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int i) {
        int i2 = this.groupGapLen;
        int i3 = this.groupGapStart;
        if (i3 != i) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i3, i);
            }
            if (i2 > 0) {
                int[] iArr = this.groups;
                int i4 = i * 5;
                int i5 = i2 * 5;
                int i6 = i3 * 5;
                if (i < i3) {
                    ArraysKt.copyInto(iArr, iArr, i5 + i4, i4, i6);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i6, i6 + i5, i4 + i5);
                }
            }
            if (i < i3) {
                i3 = i + i2;
            }
            int capacity = getCapacity();
            if (!(i3 < capacity)) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            while (i3 < capacity) {
                int i7 = (i3 * 5) + 2;
                int i8 = this.groups[i7];
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(i8), i);
                if (parentIndexToAnchor != i8) {
                    this.groups[i7] = parentIndexToAnchor;
                }
                i3++;
                if (i3 == i) {
                    i3 += i2;
                }
            }
        }
        this.groupGapStart = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int i, int i2) {
        int i3 = this.slotsGapLen;
        int i4 = this.slotsGapStart;
        int i5 = this.slotsGapOwner;
        if (i4 != i) {
            Object[] objArr = this.slots;
            if (i < i4) {
                System.arraycopy(objArr, i, objArr, i + i3, i4 - i);
            } else {
                int i6 = i4 + i3;
                System.arraycopy(objArr, i6, objArr, i4, (i + i3) - i6);
            }
        }
        int min = Math.min(i2 + 1, getSize$runtime());
        if (i5 != min) {
            int length = this.slots.length - i3;
            if (min < i5) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i5);
                int i7 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int i8 = (groupIndexToAddress * 5) + 4;
                    int i9 = this.groups[i8];
                    if (!(i9 >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    this.groups[i8] = -((length - i9) + 1);
                    groupIndexToAddress++;
                    if (groupIndexToAddress == i7) {
                        groupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i5);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int i10 = (groupIndexToAddress3 * 5) + 4;
                    int i11 = this.groups[i10];
                    if (!(i11 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    this.groups[i10] = i11 + length + 1;
                    groupIndexToAddress3++;
                    if (groupIndexToAddress3 == this.groupGapStart) {
                        groupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = i;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt.fill(this.slots, (Object) null, i, this.slotsGapLen + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int i) {
        if (i > 0) {
            int i2 = this.currentGroup;
            moveGroupGapTo(i2);
            int i3 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            if (i4 < i) {
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[max * 5];
                int i6 = max - i5;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i3 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i3 + i6) * 5, (i4 + i3) * 5, length * 5);
                this.groups = iArr2;
                i4 = i6;
            }
            int i7 = this.currentGroupEnd;
            if (i7 >= i3) {
                this.currentGroupEnd = i7 + i;
            }
            int i8 = i3 + i;
            this.groupGapStart = i8;
            this.groupGapLen = i4 - i;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(i5 > 0 ? dataIndex(i2 + i) : 0, this.slotsGapOwner >= i3 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i9 = i3; i9 < i8; i9++) {
                this.groups[(i9 * 5) + 4] = dataIndexToDataAnchor;
            }
            int i10 = this.slotsGapOwner;
            if (i10 >= i3) {
                this.slotsGapOwner = i10 + i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int i, int i2) {
        if (i > 0) {
            moveSlotGapTo(this.currentSlot, i2);
            int i3 = this.slotsGapStart;
            int i4 = this.slotsGapLen;
            if (i4 < i) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i5 = length - i4;
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[max];
                for (int i6 = 0; i6 < max; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = max - i5;
                int i8 = i4 + i3;
                System.arraycopy(objArr, 0, objArr2, 0, i3);
                System.arraycopy(objArr, i8, objArr2, i3 + i7, length - i8);
                this.slots = objArr2;
                i4 = i7;
            }
            int i9 = this.currentSlotEnd;
            if (i9 >= i3) {
                this.currentSlotEnd = i9 + i;
            }
            this.slotsGapStart = i3 + i;
            this.slotsGapLen = i4 - i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int i, int i2) {
        if (i2 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i);
            r0 = arrayList.isEmpty() ? false : removeAnchors(i, i2, this.sourceInformationMap);
            this.groupGapStart = i;
            this.groupGapLen += i2;
            int i3 = this.slotsGapOwner;
            if (i3 > i) {
                this.slotsGapOwner = Math.max(i, i3 - i2);
            }
            int i4 = this.currentGroupEnd;
            if (i4 >= this.groupGapStart) {
                this.currentGroupEnd = i4 - i2;
            }
            int i5 = this.parent;
            if (containsGroupMark(i5)) {
                updateContainsMark(i5);
            }
        }
        return r0;
    }

    public final GroupSourceInformation sourceInformationOf$runtime(int i) {
        Anchor tryAnchor$runtime;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor$runtime = tryAnchor$runtime(i)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor$runtime);
    }

    public final Anchor tryAnchor$runtime(int i) {
        if (i < 0 || i >= getSize$runtime()) {
            return null;
        }
        return SlotTableKt.access$find(this.anchors, i, getSize$runtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.slotsGapLen;
            int i5 = i + i2;
            moveSlotGapTo(i5, i3);
            this.slotsGapStart = i;
            this.slotsGapLen = i4 + i2;
            ArraysKt.fill(this.slots, (Object) null, i, i5);
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 - i2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r1[(r0 * 5) + 1] & 1073741824) != 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateNodeOfGroup(int i, Object obj) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        boolean z = groupIndexToAddress < iArr.length;
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + i + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = obj;
    }

    private final void updateAnchors(int i, int i2) {
        Anchor anchor;
        int location$runtime;
        Anchor anchor2;
        int location$runtime2;
        int i3;
        int capacity = getCapacity() - this.groupGapLen;
        if (i < i2) {
            for (int access$locationOf = SlotTableKt.access$locationOf(this.anchors, i, capacity); access$locationOf < this.anchors.size() && (location$runtime2 = (anchor2 = this.anchors.get(access$locationOf)).getLocation$runtime()) < 0 && (i3 = location$runtime2 + capacity) < i2; access$locationOf++) {
                anchor2.setLocation$runtime(i3);
            }
            return;
        }
        for (int access$locationOf2 = SlotTableKt.access$locationOf(this.anchors, i2, capacity); access$locationOf2 < this.anchors.size() && (location$runtime = (anchor = this.anchors.get(access$locationOf2)).getLocation$runtime()) >= 0; access$locationOf2++) {
            anchor.setLocation$runtime(-(capacity - location$runtime));
        }
    }

    private final boolean removeAnchors(int i, int i2, HashMap<Anchor, GroupSourceInformation> hashMap) {
        int i3 = i2 + i;
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i4 = access$locationOf + 1;
        int i5 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            int anchorIndex = anchorIndex(anchor);
            if (anchorIndex < i) {
                break;
            }
            if (anchorIndex < i3) {
                anchor.setLocation$runtime(Integer.MIN_VALUE);
                if (hashMap != null) {
                    hashMap.remove(anchor);
                }
                if (i5 == 0) {
                    i5 = access$locationOf + 1;
                }
                i4 = access$locationOf;
            }
            access$locationOf--;
        }
        boolean z = i4 < i5;
        if (z) {
            this.anchors.subList(i4, i5).clear();
        }
        return z;
    }

    private final void moveAnchors(int i, int i2, int i3) {
        Anchor anchor;
        int anchorIndex;
        int i4 = i3 + i;
        int size$runtime = getSize$runtime();
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, i, size$runtime);
        ArrayList arrayList = new ArrayList();
        if (access$locationOf >= 0) {
            while (access$locationOf < this.anchors.size() && (anchorIndex = anchorIndex((anchor = this.anchors.get(access$locationOf)))) >= i && anchorIndex < i4) {
                arrayList.add(anchor);
                this.anchors.remove(access$locationOf);
            }
        }
        int i5 = i2 - i;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Anchor anchor2 = (Anchor) arrayList.get(i6);
            int anchorIndex2 = anchorIndex(anchor2) + i5;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime(-(size$runtime - anchorIndex2));
            } else {
                anchor2.setLocation$runtime(anchorIndex2);
            }
            this.anchors.add(SlotTableKt.access$locationOf(this.anchors, anchorIndex2, size$runtime), anchor2);
        }
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(toString());
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        StringBuilder append2 = sb.append("  parent:    " + this.parent);
        Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append(...)");
        StringBuilder append3 = sb.append("  current:   " + this.currentGroup);
        Intrinsics.checkNotNullExpressionValue(append3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append(...)");
        StringBuilder append4 = sb.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append4, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append(...)");
        StringBuilder append5 = sb.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append5, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append5.append('\n'), "append(...)");
        StringBuilder append6 = sb.append("  gap owner: " + this.slotsGapOwner);
        Intrinsics.checkNotNullExpressionValue(append6, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append(...)");
        int size$runtime = getSize$runtime();
        for (int i = 0; i < size$runtime; i++) {
            groupAsString(sb, i);
            sb.append('\n');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (groupIndexToAddress != i) {
            sb.append("(");
            sb.append(groupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.access$groupSize(this.groups, groupIndexToAddress));
        sb.append('^');
        int i2 = groupIndexToAddress * 5;
        int i3 = i2 + 2;
        sb.append(parentAnchorToIndex(this.groups[i3]));
        sb.append(": key=");
        sb.append(this.groups[i2]);
        sb.append(", nodes=");
        int i4 = i2 + 1;
        sb.append(this.groups[i4] & RectListKt.Lower26Bits);
        sb.append(", dataAnchor=");
        sb.append(this.groups[i2 + 4]);
        sb.append(", parentAnchor=");
        sb.append(this.groups[i3]);
        if ((this.groups[i4] & 1073741824) != 0) {
            sb.append(", node=" + SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]), 10));
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        if (dataIndex > slotIndex) {
            sb.append(", [");
            for (int i5 = slotIndex; i5 < dataIndex; i5++) {
                if (i5 != slotIndex) {
                    sb.append(", ");
                }
                sb.append(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(i5)]), 10));
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        sb.append(")");
    }

    public final void verifyDataAnchors$runtime() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime = getSize$runtime();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < size$runtime) {
            int groupIndexToAddress = groupIndexToAddress(i2);
            int[] iArr = this.groups;
            int i4 = iArr[(groupIndexToAddress * 5) + 4];
            int dataIndex = dataIndex(iArr, groupIndexToAddress);
            if (!(dataIndex >= i3)) {
                PreconditionsKt.throwIllegalStateException("Data index out of order at " + i2 + ", previous = " + i3 + ", current = " + dataIndex);
            }
            if (!(dataIndex <= length)) {
                PreconditionsKt.throwIllegalStateException("Data index, " + dataIndex + ", out of bound at " + i2);
            }
            if (i4 < 0 && !z) {
                if (!(i == i2)) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + i + " found gap at " + i2);
                }
                z = true;
            }
            i2++;
            i3 = dataIndex;
        }
    }

    public final void verifyParentAnchors$runtime() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                break;
            }
            if (!(this.groups[(i3 * 5) + 2] > -2)) {
                PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i3);
            }
            i3++;
        }
        for (int i4 = i2 + i; i4 < capacity; i4++) {
            int i5 = this.groups[(i4 * 5) + 2];
            if (parentAnchorToIndex(i5) < i) {
                if (!(i5 > -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i4);
                }
            } else if (!(i5 <= -2)) {
                PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + i4);
            }
        }
    }

    public final int getSize$runtime() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int i) {
        return i + (this.groupGapLen * (i < this.groupGapStart ? 0 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i) {
        return i + (this.slotsGapLen * (i < this.slotsGapStart ? 0 : 1));
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(iArr[(groupIndexToAddress(i) * 5) + 2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(iArr[(i * 5) + 4], this.slotsGapLen, this.slots.length);
    }

    private final int slotIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.access$slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 4] = dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length);
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + Integer.bitCount(iArr[(i * 5) + 1] >> 29);
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List plus = CollectionsKt.plus((Collection) CollectionsKt.slice(dataAnchors$default, RangesKt.until(0, this.groupGapStart)), (Iterable) CollectionsKt.slice(dataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        for (int i = 0; i < size; i++) {
            Object obj = keys$default.get(i);
            ((Number) obj).intValue();
            int i2 = this.groupGapStart;
            if (i < i2 || i >= i2 + this.groupGapLen) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int parentIndexToAnchor(int i, int i2) {
        return i < i2 ? i : -((getSize$runtime() - i) + 2);
    }

    private final int parentAnchorToIndex(int i) {
        return i > -2 ? i : (getSize$runtime() + i) - (-2);
    }

    public final void trimTailSlots(int i) {
        if (!(i > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i2 = this.parent;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i2));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2 + 1)) - i;
        if (!(dataIndex >= slotIndex)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        removeSlots(dataIndex, i, i2);
        int i3 = this.currentSlot;
        if (i3 >= slotIndex) {
            this.currentSlot = i3 - i;
        }
    }

    public final void forAllDataInRememberOrder(int i, Function2<? super Integer, Object, Unit> function2) {
        int i2;
        int i3;
        Anchor after;
        Function2<? super Integer, Object, Unit> function22 = function2;
        int parent = parent(i);
        int size$runtime = getSize$runtime();
        int groupSize = groupSize(i) + i;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i4 = i;
        MutableIntSet mutableIntSet = null;
        MutableIntList mutableIntList = null;
        while (i4 < groupSize) {
            int dataIndex = dataIndex(i4);
            int i5 = i4 + 1;
            int dataIndex2 = dataIndex(i5);
            while (true) {
                i2 = 0;
                if (dataIndex >= dataIndex2) {
                    break;
                }
                Object obj = this.slots[dataIndexToDataAddress(dataIndex)];
                if ((obj instanceof RememberObserverHolder) && (after = ((RememberObserverHolder) obj).getAfter()) != null && after.getValid()) {
                    int anchorIndex = anchorIndex(after);
                    if (mutableIntSet == null) {
                        mutableIntSet = IntSetKt.mutableIntSetOf();
                    }
                    if (mutableIntList == null) {
                        mutableIntList = new MutableIntList(0, 1, defaultConstructorMarker);
                    }
                    mutableIntSet.add(anchorIndex);
                    mutableIntList.add(anchorIndex);
                    mutableIntList.add(dataIndex);
                } else {
                    function22.invoke(Integer.valueOf(dataIndex), obj);
                }
                dataIndex++;
            }
            int parent2 = i5 < size$runtime ? parent(i5) : -1;
            if (parent2 != i4) {
                while (true) {
                    if (mutableIntList == null || mutableIntSet == null || !mutableIntSet.remove(i4)) {
                        i3 = size$runtime;
                    } else {
                        int i6 = mutableIntList._size;
                        int i7 = i6 / 2;
                        int i8 = i2;
                        int i9 = i8;
                        while (i9 < i7) {
                            int i10 = i9 * 2;
                            int i11 = size$runtime;
                            int i12 = mutableIntList.get(i10);
                            if (i12 == i4) {
                                int i13 = mutableIntList.get(i10 + 1);
                                function22.invoke(Integer.valueOf(i13), this.slots[dataIndexToDataAddress(i13)]);
                            } else if (i10 != i8) {
                                int i14 = i8 + 1;
                                mutableIntList.set(i8, i12);
                                i8 += 2;
                                mutableIntList.set(i14, mutableIntList.get(i10 + 1));
                            } else {
                                i8 += 2;
                            }
                            i9++;
                            function22 = function2;
                            size$runtime = i11;
                        }
                        i3 = size$runtime;
                        if (i8 != i6) {
                            mutableIntList.removeRange(i8, i6);
                        }
                    }
                    if (i4 != i && parent != parent2) {
                        i4 = parent;
                        size$runtime = i3;
                        i2 = 0;
                        parent = parent(parent);
                        function22 = function2;
                    }
                }
            } else {
                i3 = size$runtime;
            }
            function22 = function2;
            parent = parent2;
            i4 = i5;
            size$runtime = i3;
            defaultConstructorMarker = null;
        }
    }
}

package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlinx.metadata.internal.BooleanFlagDelegate;
import kotlinx.metadata.internal.EnumFlagDelegate;
import kotlinx.metadata.internal.FlagDelegatesImplKt;
import kotlinx.metadata.internal.FlagImpl;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: Attributes.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"/\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\"/\u0010\n\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\t\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u000e\u0010\u0013\"/\u0010\n\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\f\u0010\u0016\"\u0004\b\u000e\u0010\u0017\"/\u0010\n\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\t\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u000e\u0010\u001b\"/\u0010\n\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b\f\u0010\u001e\"\u0004\b\u000e\u0010\u001f\"/\u0010\n\u001a\u00020\u0001*\u00020!2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\t\u001a\u0004\b\f\u0010\"\"\u0004\b\u000e\u0010#\"/\u0010\n\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\t\u001a\u0004\b\f\u0010\u0005\"\u0004\b\u000e\u0010\u0007\"/\u0010&\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001b\"/\u0010*\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\t\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000f\"5\u0010.\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b3\u0010\t\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001b\"/\u00104\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\t\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0013\"/\u00104\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\t\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0017\"5\u00109\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b=\u0010\t\u0012\u0004\b:\u00100\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001b\"/\u0010>\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\t\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001b\"/\u0010A\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\t\u001a\u0004\bA\u0010\u0005\"\u0004\bB\u0010\u0007\"/\u0010D\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010\t\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000f\"/\u0010G\u001a\u00020\u0001*\u00020H2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\t\u001a\u0004\bG\u0010I\"\u0004\bJ\u0010K\"/\u0010M\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\t\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010\u001b\"/\u0010P\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\t\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000f\"/\u0010P\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010\t\u001a\u0004\bP\u0010\u0016\"\u0004\bQ\u0010\u0017\"/\u0010P\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010\t\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001b\"/\u0010U\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\t\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000f\"/\u0010U\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010\t\u001a\u0004\bU\u0010\u0016\"\u0004\bV\u0010\u0017\"/\u0010U\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010\t\u001a\u0004\bU\u0010\u001a\"\u0004\bV\u0010\u001b\"/\u0010U\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\t\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010\u001f\"/\u0010[\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010\t\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000f\"/\u0010^\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\t\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010\u0017\"/\u0010a\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010\t\u001a\u0004\ba\u0010\u0016\"\u0004\bb\u0010\u0017\"/\u0010a\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010\t\u001a\u0004\ba\u0010\u001e\"\u0004\bb\u0010\u001f\"/\u0010e\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010\t\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000f\"/\u0010h\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010\t\u001a\u0004\bh\u0010\u001a\"\u0004\bi\u0010\u001b\"5\u0010k\u001a\u00020\u0001*\u00020l2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\br\u0010\t\u0012\u0004\bm\u0010n\u001a\u0004\bk\u0010o\"\u0004\bp\u0010q\"/\u0010s\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bu\u0010\t\u001a\u0004\bs\u0010\u0005\"\u0004\bt\u0010\u0007\"/\u0010v\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bx\u0010\t\u001a\u0004\bv\u0010\u001e\"\u0004\bw\u0010\u001f\"5\u0010y\u001a\u00020\u0001*\u00020l2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b|\u0010\t\u0012\u0004\bz\u0010n\u001a\u0004\by\u0010o\"\u0004\b{\u0010q\"/\u0010}\u001a\u00020\u0001*\u00020H2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u007f\u0010\t\u001a\u0004\b}\u0010I\"\u0004\b~\u0010K\"3\u0010\u0080\u0001\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\t\u001a\u0005\b\u0080\u0001\u0010\u0016\"\u0005\b\u0081\u0001\u0010\u0017\"6\u0010\u0083\u0001\u001a\u00020\u0001*\u00030\u0084\u00012\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u0088\u0001\u0010\t\u001a\u0006\b\u0083\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001\"3\u0010\u0089\u0001\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010\t\u001a\u0005\b\u0089\u0001\u0010\u0012\"\u0005\b\u008a\u0001\u0010\u0013\"3\u0010\u008c\u0001\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010\t\u001a\u0005\b\u008c\u0001\u0010\u0016\"\u0005\b\u008d\u0001\u0010\u0017\"3\u0010\u008c\u0001\u001a\u00020\u0001*\u00020H2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\t\u001a\u0005\b\u008c\u0001\u0010I\"\u0005\b\u008d\u0001\u0010K\"3\u0010\u0090\u0001\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\t\u001a\u0005\b\u0090\u0001\u0010\u0016\"\u0005\b\u0091\u0001\u0010\u0017\"3\u0010\u0093\u0001\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\t\u001a\u0005\b\u0093\u0001\u0010\r\"\u0005\b\u0094\u0001\u0010\u000f\"3\u0010\u0096\u0001\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\t\u001a\u0005\b\u0096\u0001\u0010\u001a\"\u0005\b\u0097\u0001\u0010\u001b\"8\u0010\u009a\u0001\u001a\u00030\u0099\u0001*\u00020\u000b2\u0007\u0010\u0000\u001a\u00030\u0099\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001\"8\u0010\u009a\u0001\u001a\u00030¡\u0001*\u00020\u00152\u0007\u0010\u0000\u001a\u00030¡\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b¤\u0001\u0010 \u0001\u001a\u0006\b\u009b\u0001\u0010¢\u0001\"\u0006\b\u009d\u0001\u0010£\u0001\"8\u0010\u009a\u0001\u001a\u00030¡\u0001*\u00020\u00192\u0007\u0010\u0000\u001a\u00030¡\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b§\u0001\u0010 \u0001\u001a\u0006\b\u009b\u0001\u0010¥\u0001\"\u0006\b\u009d\u0001\u0010¦\u0001\"8\u0010©\u0001\u001a\u00030¨\u0001*\u00020\u000b2\u0007\u0010\u0000\u001a\u00030¨\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b®\u0001\u0010 \u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001\"8\u0010©\u0001\u001a\u00030¨\u0001*\u00020\u00152\u0007\u0010\u0000\u001a\u00030¨\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b±\u0001\u0010 \u0001\u001a\u0006\bª\u0001\u0010¯\u0001\"\u0006\b¬\u0001\u0010°\u0001\"8\u0010©\u0001\u001a\u00030¨\u0001*\u00020\u00192\u0007\u0010\u0000\u001a\u00030¨\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b´\u0001\u0010 \u0001\u001a\u0006\bª\u0001\u0010²\u0001\"\u0006\b¬\u0001\u0010³\u0001\"8\u0010©\u0001\u001a\u00030¨\u0001*\u00020\u001d2\u0007\u0010\u0000\u001a\u00030¨\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b·\u0001\u0010 \u0001\u001a\u0006\bª\u0001\u0010µ\u0001\"\u0006\b¬\u0001\u0010¶\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020\u000b2\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b¾\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020\u00112\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\bÁ\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010¿\u0001\"\u0006\b¼\u0001\u0010À\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020\u00152\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\bÄ\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010Â\u0001\"\u0006\b¼\u0001\u0010Ã\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020\u00192\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\bÇ\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010Å\u0001\"\u0006\b¼\u0001\u0010Æ\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020\u001d2\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\bÊ\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010È\u0001\"\u0006\b¼\u0001\u0010É\u0001\"8\u0010¹\u0001\u001a\u00030¸\u0001*\u00020!2\u0007\u0010\u0000\u001a\u00030¸\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\bÍ\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010Ë\u0001\"\u0006\b¼\u0001\u0010Ì\u0001¨\u0006Î\u0001"}, d2 = {"<set-?>", "", "declaresDefaultValue", "Lkotlinx/metadata/KmValueParameter;", "getDeclaresDefaultValue", "(Lkotlinx/metadata/KmValueParameter;)Z", "setDeclaresDefaultValue", "(Lkotlinx/metadata/KmValueParameter;Z)V", "declaresDefaultValue$delegate", "Lkotlinx/metadata/internal/BooleanFlagDelegate;", "hasAnnotations", "Lkotlinx/metadata/KmClass;", "getHasAnnotations", "(Lkotlinx/metadata/KmClass;)Z", "setHasAnnotations", "(Lkotlinx/metadata/KmClass;Z)V", "hasAnnotations$delegate", "Lkotlinx/metadata/KmConstructor;", "(Lkotlinx/metadata/KmConstructor;)Z", "(Lkotlinx/metadata/KmConstructor;Z)V", "hasAnnotations$delegate$1", "Lkotlinx/metadata/KmFunction;", "(Lkotlinx/metadata/KmFunction;)Z", "(Lkotlinx/metadata/KmFunction;Z)V", "hasAnnotations$delegate$2", "Lkotlinx/metadata/KmProperty;", "(Lkotlinx/metadata/KmProperty;)Z", "(Lkotlinx/metadata/KmProperty;Z)V", "hasAnnotations$delegate$3", "Lkotlinx/metadata/KmPropertyAccessorAttributes;", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Z", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;Z)V", "hasAnnotations$delegate$4", "Lkotlinx/metadata/KmTypeAlias;", "(Lkotlinx/metadata/KmTypeAlias;)Z", "(Lkotlinx/metadata/KmTypeAlias;Z)V", "hasAnnotations$delegate$6", "hasAnnotations$delegate$5", "hasConstant", "getHasConstant", "setHasConstant", "hasConstant$delegate", "hasEnumEntries", "getHasEnumEntries", "setHasEnumEntries", "hasEnumEntries$delegate", "hasGetter", "getHasGetter$annotations", "(Lkotlinx/metadata/KmProperty;)V", "getHasGetter", "setHasGetter", "hasGetter$delegate", "hasNonStableParameterNames", "getHasNonStableParameterNames", "setHasNonStableParameterNames", "hasNonStableParameterNames$delegate", "hasNonStableParameterNames$delegate$1", "hasSetter", "getHasSetter$annotations", "getHasSetter", "setHasSetter", "hasSetter$delegate", "isConst", "setConst", "isConst$delegate", "isCrossinline", "setCrossinline", "isCrossinline$delegate", "isData", "setData", "isData$delegate", "isDefinitelyNonNull", "Lkotlinx/metadata/KmType;", "(Lkotlinx/metadata/KmType;)Z", "setDefinitelyNonNull", "(Lkotlinx/metadata/KmType;Z)V", "isDefinitelyNonNull$delegate", "isDelegated", "setDelegated", "isDelegated$delegate", "isExpect", "setExpect", "isExpect$delegate", "isExpect$delegate$1", "isExpect$delegate$2", "isExternal", "setExternal", "isExternal$delegate", "isExternal$delegate$1", "isExternal$delegate$2", "isExternal$delegate$3", "isFunInterface", "setFunInterface", "isFunInterface$delegate", "isInfix", "setInfix", "isInfix$delegate", "isInline", "setInline", "isInline$delegate", "isInline$delegate$1", "isInner", "setInner", "isInner$delegate", "isLateinit", "setLateinit", "isLateinit$delegate", "isNegated", "Lkotlinx/metadata/KmEffectExpression;", "isNegated$annotations", "(Lkotlinx/metadata/KmEffectExpression;)V", "(Lkotlinx/metadata/KmEffectExpression;)Z", "setNegated", "(Lkotlinx/metadata/KmEffectExpression;Z)V", "isNegated$delegate", "isNoinline", "setNoinline", "isNoinline$delegate", "isNotDefault", "setNotDefault", "isNotDefault$delegate", "isNullCheckPredicate", "isNullCheckPredicate$annotations", "setNullCheckPredicate", "isNullCheckPredicate$delegate", "isNullable", "setNullable", "isNullable$delegate", "isOperator", "setOperator", "isOperator$delegate", "isReified", "Lkotlinx/metadata/KmTypeParameter;", "(Lkotlinx/metadata/KmTypeParameter;)Z", "setReified", "(Lkotlinx/metadata/KmTypeParameter;Z)V", "isReified$delegate", "isSecondary", "setSecondary", "isSecondary$delegate", "isSuspend", "setSuspend", "isSuspend$delegate", "isSuspend$delegate$1", "isTailrec", "setTailrec", "isTailrec$delegate", "isValue", "setValue", "isValue$delegate", "isVar", "setVar", "isVar$delegate", "Lkotlinx/metadata/ClassKind;", "kind", "getKind", "(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/ClassKind;", "setKind", "(Lkotlinx/metadata/KmClass;Lkotlinx/metadata/ClassKind;)V", "kind$delegate", "Lkotlinx/metadata/internal/EnumFlagDelegate;", "Lkotlinx/metadata/MemberKind;", "(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/MemberKind;", "(Lkotlinx/metadata/KmFunction;Lkotlinx/metadata/MemberKind;)V", "kind$delegate$1", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/MemberKind;", "(Lkotlinx/metadata/KmProperty;Lkotlinx/metadata/MemberKind;)V", "kind$delegate$2", "Lkotlinx/metadata/Modality;", "modality", "getModality", "(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/Modality;", "setModality", "(Lkotlinx/metadata/KmClass;Lkotlinx/metadata/Modality;)V", "modality$delegate", "(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/Modality;", "(Lkotlinx/metadata/KmFunction;Lkotlinx/metadata/Modality;)V", "modality$delegate$1", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/Modality;", "(Lkotlinx/metadata/KmProperty;Lkotlinx/metadata/Modality;)V", "modality$delegate$2", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Lkotlinx/metadata/Modality;", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;Lkotlinx/metadata/Modality;)V", "modality$delegate$3", "Lkotlinx/metadata/Visibility;", "visibility", "getVisibility", "(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/Visibility;", "setVisibility", "(Lkotlinx/metadata/KmClass;Lkotlinx/metadata/Visibility;)V", "visibility$delegate", "(Lkotlinx/metadata/KmConstructor;)Lkotlinx/metadata/Visibility;", "(Lkotlinx/metadata/KmConstructor;Lkotlinx/metadata/Visibility;)V", "visibility$delegate$1", "(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/Visibility;", "(Lkotlinx/metadata/KmFunction;Lkotlinx/metadata/Visibility;)V", "visibility$delegate$2", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/Visibility;", "(Lkotlinx/metadata/KmProperty;Lkotlinx/metadata/Visibility;)V", "visibility$delegate$3", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Lkotlinx/metadata/Visibility;", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;Lkotlinx/metadata/Visibility;)V", "visibility$delegate$4", "(Lkotlinx/metadata/KmTypeAlias;)Lkotlinx/metadata/Visibility;", "(Lkotlinx/metadata/KmTypeAlias;Lkotlinx/metadata/Visibility;)V", "visibility$delegate$5", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Attributes {
    private static final BooleanFlagDelegate declaresDefaultValue$delegate;
    private static final BooleanFlagDelegate hasConstant$delegate;
    private static final BooleanFlagDelegate hasEnumEntries$delegate;
    private static final BooleanFlagDelegate hasGetter$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate$1;
    private static final BooleanFlagDelegate hasSetter$delegate;
    private static final BooleanFlagDelegate isConst$delegate;
    private static final BooleanFlagDelegate isCrossinline$delegate;
    private static final BooleanFlagDelegate isData$delegate;
    private static final BooleanFlagDelegate isDefinitelyNonNull$delegate;
    private static final BooleanFlagDelegate isDelegated$delegate;
    private static final BooleanFlagDelegate isExpect$delegate;
    private static final BooleanFlagDelegate isExpect$delegate$1;
    private static final BooleanFlagDelegate isExpect$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate;
    private static final BooleanFlagDelegate isExternal$delegate$1;
    private static final BooleanFlagDelegate isExternal$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate$3;
    private static final BooleanFlagDelegate isFunInterface$delegate;
    private static final BooleanFlagDelegate isInfix$delegate;
    private static final BooleanFlagDelegate isInline$delegate;
    private static final BooleanFlagDelegate isInline$delegate$1;
    private static final BooleanFlagDelegate isInner$delegate;
    private static final BooleanFlagDelegate isLateinit$delegate;
    private static final BooleanFlagDelegate isNegated$delegate;
    private static final BooleanFlagDelegate isNoinline$delegate;
    private static final BooleanFlagDelegate isNotDefault$delegate;
    private static final BooleanFlagDelegate isNullCheckPredicate$delegate;
    private static final BooleanFlagDelegate isNullable$delegate;
    private static final BooleanFlagDelegate isOperator$delegate;
    private static final BooleanFlagDelegate isReified$delegate;
    private static final BooleanFlagDelegate isSecondary$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate$1;
    private static final BooleanFlagDelegate isTailrec$delegate;
    private static final BooleanFlagDelegate isValue$delegate;
    private static final BooleanFlagDelegate isVar$delegate;
    private static final EnumFlagDelegate kind$delegate;
    private static final EnumFlagDelegate kind$delegate$1;
    private static final EnumFlagDelegate kind$delegate$2;
    private static final EnumFlagDelegate modality$delegate$1;
    private static final EnumFlagDelegate modality$delegate$2;
    private static final EnumFlagDelegate modality$delegate$3;
    private static final EnumFlagDelegate visibility$delegate$1;
    private static final EnumFlagDelegate visibility$delegate$2;
    private static final EnumFlagDelegate visibility$delegate$3;
    private static final EnumFlagDelegate visibility$delegate$4;
    private static final EnumFlagDelegate visibility$delegate$5;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmConstructor;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmValueParameter;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasAnnotations", "getHasAnnotations(Lkotlinx/metadata/KmTypeAlias;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "modality", "getModality(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/Modality;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "kind", "getKind(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/ClassKind;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isInner", "isInner(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isData", "isData(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExternal", "isExternal(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExpect", "isExpect(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isValue", "isValue(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isFunInterface", "isFunInterface(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasEnumEntries", "getHasEnumEntries(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmConstructor;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isSecondary", "isSecondary(Lkotlinx/metadata/KmConstructor;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlinx/metadata/KmConstructor;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "kind", "getKind(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/MemberKind;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "modality", "getModality(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/Modality;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isOperator", "isOperator(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isInfix", "isInfix(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isInline", "isInline(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isTailrec", "isTailrec(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExternal", "isExternal(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isSuspend", "isSuspend(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExpect", "isExpect(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlinx/metadata/KmFunction;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "modality", "getModality(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/Modality;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "kind", "getKind(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/MemberKind;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isVar", "isVar(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasGetter", "getHasGetter(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasSetter", "getHasSetter(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isConst", "isConst(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isLateinit", "isLateinit(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "hasConstant", "getHasConstant(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExternal", "isExternal(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isDelegated", "isDelegated(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExpect", "isExpect(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "modality", "getModality(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Lkotlinx/metadata/Modality;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isNotDefault", "isNotDefault(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isExternal", "isExternal(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isInline", "isInline(Lkotlinx/metadata/KmPropertyAccessorAttributes;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isNullable", "isNullable(Lkotlinx/metadata/KmType;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isSuspend", "isSuspend(Lkotlinx/metadata/KmType;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlinx/metadata/KmType;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isReified", "isReified(Lkotlinx/metadata/KmTypeParameter;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "visibility", "getVisibility(Lkotlinx/metadata/KmTypeAlias;)Lkotlinx/metadata/Visibility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlinx/metadata/KmValueParameter;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isCrossinline", "isCrossinline(Lkotlinx/metadata/KmValueParameter;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isNoinline", "isNoinline(Lkotlinx/metadata/KmValueParameter;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isNegated", "isNegated(Lkotlinx/metadata/KmEffectExpression;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(Attributes.class, "kotlinx-metadata"), "isNullCheckPredicate", "isNullCheckPredicate(Lkotlinx/metadata/KmEffectExpression;)Z"))};
    private static final BooleanFlagDelegate hasAnnotations$delegate = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$2
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmClass) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmClass.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmClass) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$1 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$6
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmConstructor) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmConstructor.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmConstructor) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$2 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$10
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmFunction) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmFunction.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmFunction) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$3 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$14
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmProperty) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmProperty.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmProperty) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$4 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$18
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlinx_metadata());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmPropertyAccessorAttributes.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags$kotlinx_metadata()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmPropertyAccessorAttributes) obj).setFlags$kotlinx_metadata(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$5 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$22
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmValueParameter) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmValueParameter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmValueParameter) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final BooleanFlagDelegate hasAnnotations$delegate$6 = FlagDelegatesImplKt.annotationsOn(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$hasAnnotations$26
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmTypeAlias) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmTypeAlias.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmTypeAlias) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final EnumFlagDelegate modality$delegate = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$modality$2
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmClass) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmClass.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmClass) obj).setFlags(((Number) obj2).intValue());
        }
    });
    private static final EnumFlagDelegate visibility$delegate = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$2
        @Override // kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return Integer.valueOf(((KmClass) obj).getFlags());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return DownloaderServiceMarshaller.PARAMS_FLAGS;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KmClass.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getFlags()I";
        }

        @Override // kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((KmClass) obj).setFlags(((Number) obj2).intValue());
        }
    });

    @Deprecated(level = DeprecationLevel.ERROR, message = "Kotlin properties always have getters", replaceWith = @ReplaceWith(expression = "true", imports = {}))
    public static /* synthetic */ void getHasGetter$annotations(KmProperty kmProperty) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Check .setter for nullability instead", replaceWith = @ReplaceWith(expression = "this.setter != null", imports = {}))
    public static /* synthetic */ void getHasSetter$annotations(KmProperty kmProperty) {
    }

    public static /* synthetic */ void isNegated$annotations(KmEffectExpression kmEffectExpression) {
    }

    public static /* synthetic */ void isNullCheckPredicate$annotations(KmEffectExpression kmEffectExpression) {
    }

    static {
        Attributes$kind$2 attributes$kind$2 = new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$kind$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmClass.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags(((Number) obj2).intValue());
            }
        };
        Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND = Flags.CLASS_KIND;
        Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
        EnumEntries<ClassKind> entries = ClassKind.getEntries();
        EnumEntries<ClassKind> entries2 = ClassKind.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        for (ClassKind classKind : entries2) {
            arrayList.add(classKind.getFlag$kotlinx_metadata());
        }
        kind$delegate = new EnumFlagDelegate(attributes$kind$2, CLASS_KIND, entries, arrayList);
        Flags.BooleanFlagField IS_INNER = Flags.IS_INNER;
        Intrinsics.checkNotNullExpressionValue(IS_INNER, "IS_INNER");
        isInner$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_INNER));
        Flags.BooleanFlagField IS_DATA = Flags.IS_DATA;
        Intrinsics.checkNotNullExpressionValue(IS_DATA, "IS_DATA");
        isData$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_DATA));
        Flags.BooleanFlagField IS_EXTERNAL_CLASS = Flags.IS_EXTERNAL_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
        isExternal$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_EXTERNAL_CLASS));
        Flags.BooleanFlagField IS_EXPECT_CLASS = Flags.IS_EXPECT_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
        isExpect$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_EXPECT_CLASS));
        Flags.BooleanFlagField IS_VALUE_CLASS = Flags.IS_VALUE_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_VALUE_CLASS, "IS_VALUE_CLASS");
        isValue$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_VALUE_CLASS));
        Flags.BooleanFlagField IS_FUN_INTERFACE = Flags.IS_FUN_INTERFACE;
        Intrinsics.checkNotNullExpressionValue(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
        isFunInterface$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_FUN_INTERFACE));
        Flags.BooleanFlagField HAS_ENUM_ENTRIES = Flags.HAS_ENUM_ENTRIES;
        Intrinsics.checkNotNullExpressionValue(HAS_ENUM_ENTRIES, "HAS_ENUM_ENTRIES");
        hasEnumEntries$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(HAS_ENUM_ENTRIES));
        visibility$delegate$1 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$6
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmConstructor) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmConstructor.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmConstructor) obj).setFlags(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField IS_SECONDARY = Flags.IS_SECONDARY;
        Intrinsics.checkNotNullExpressionValue(IS_SECONDARY, "IS_SECONDARY");
        isSecondary$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(IS_SECONDARY));
        Flags.BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES));
        kind$delegate$1 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$kind$7
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmFunction.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags(((Number) obj2).intValue());
            }
        });
        visibility$delegate$2 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$10
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmFunction.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags(((Number) obj2).intValue());
            }
        });
        modality$delegate$1 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$modality$6
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmFunction.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField IS_OPERATOR = Flags.IS_OPERATOR;
        Intrinsics.checkNotNullExpressionValue(IS_OPERATOR, "IS_OPERATOR");
        isOperator$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_OPERATOR));
        Flags.BooleanFlagField IS_INFIX = Flags.IS_INFIX;
        Intrinsics.checkNotNullExpressionValue(IS_INFIX, "IS_INFIX");
        isInfix$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_INFIX));
        Flags.BooleanFlagField IS_INLINE = Flags.IS_INLINE;
        Intrinsics.checkNotNullExpressionValue(IS_INLINE, "IS_INLINE");
        isInline$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_INLINE));
        Flags.BooleanFlagField IS_TAILREC = Flags.IS_TAILREC;
        Intrinsics.checkNotNullExpressionValue(IS_TAILREC, "IS_TAILREC");
        isTailrec$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_TAILREC));
        Flags.BooleanFlagField IS_EXTERNAL_FUNCTION = Flags.IS_EXTERNAL_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
        isExternal$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_EXTERNAL_FUNCTION));
        Flags.BooleanFlagField IS_SUSPEND = Flags.IS_SUSPEND;
        Intrinsics.checkNotNullExpressionValue(IS_SUSPEND, "IS_SUSPEND");
        isSuspend$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_SUSPEND));
        Flags.BooleanFlagField IS_EXPECT_FUNCTION = Flags.IS_EXPECT_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
        isExpect$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_EXPECT_FUNCTION));
        Flags.BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES));
        visibility$delegate$3 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$14
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmProperty.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags(((Number) obj2).intValue());
            }
        });
        modality$delegate$2 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$modality$10
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmProperty.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags(((Number) obj2).intValue());
            }
        });
        kind$delegate$2 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$kind$11
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmProperty.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField IS_VAR = Flags.IS_VAR;
        Intrinsics.checkNotNullExpressionValue(IS_VAR, "IS_VAR");
        isVar$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_VAR));
        Flags.BooleanFlagField HAS_GETTER = Flags.HAS_GETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_GETTER, "HAS_GETTER");
        hasGetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_GETTER));
        Flags.BooleanFlagField HAS_SETTER = Flags.HAS_SETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_SETTER, "HAS_SETTER");
        hasSetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_SETTER));
        Flags.BooleanFlagField IS_CONST = Flags.IS_CONST;
        Intrinsics.checkNotNullExpressionValue(IS_CONST, "IS_CONST");
        isConst$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_CONST));
        Flags.BooleanFlagField IS_LATEINIT = Flags.IS_LATEINIT;
        Intrinsics.checkNotNullExpressionValue(IS_LATEINIT, "IS_LATEINIT");
        isLateinit$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_LATEINIT));
        Flags.BooleanFlagField HAS_CONSTANT = Flags.HAS_CONSTANT;
        Intrinsics.checkNotNullExpressionValue(HAS_CONSTANT, "HAS_CONSTANT");
        hasConstant$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_CONSTANT));
        Flags.BooleanFlagField IS_EXTERNAL_PROPERTY = Flags.IS_EXTERNAL_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
        isExternal$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_EXTERNAL_PROPERTY));
        Flags.BooleanFlagField IS_DELEGATED = Flags.IS_DELEGATED;
        Intrinsics.checkNotNullExpressionValue(IS_DELEGATED, "IS_DELEGATED");
        isDelegated$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_DELEGATED));
        Flags.BooleanFlagField IS_EXPECT_PROPERTY = Flags.IS_EXPECT_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
        isExpect$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_EXPECT_PROPERTY));
        visibility$delegate$4 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$18
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlinx_metadata());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmPropertyAccessorAttributes.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags$kotlinx_metadata()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlinx_metadata(((Number) obj2).intValue());
            }
        });
        modality$delegate$3 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$modality$14
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlinx_metadata());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmPropertyAccessorAttributes.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags$kotlinx_metadata()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlinx_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField IS_NOT_DEFAULT = Flags.IS_NOT_DEFAULT;
        Intrinsics.checkNotNullExpressionValue(IS_NOT_DEFAULT, "IS_NOT_DEFAULT");
        isNotDefault$delegate = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_NOT_DEFAULT));
        Flags.BooleanFlagField IS_EXTERNAL_ACCESSOR = Flags.IS_EXTERNAL_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
        isExternal$delegate$3 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_EXTERNAL_ACCESSOR));
        Flags.BooleanFlagField IS_INLINE_ACCESSOR = Flags.IS_INLINE_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
        isInline$delegate$1 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_INLINE_ACCESSOR));
        isNullable$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(0, 1, 1));
        isSuspend$delegate$1 = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.SUSPEND_TYPE.offset + 1, Flags.SUSPEND_TYPE.bitWidth, 1));
        isDefinitelyNonNull$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.DEFINITELY_NOT_NULL_TYPE.offset + 1, Flags.DEFINITELY_NOT_NULL_TYPE.bitWidth, 1));
        isReified$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$isReified$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmTypeParameter) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmTypeParameter.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmTypeParameter) obj).setFlags(((Number) obj2).intValue());
            }
        }, new FlagImpl(0, 1, 1));
        visibility$delegate$5 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$visibility$22
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmTypeAlias) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmTypeAlias.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmTypeAlias) obj).setFlags(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField DECLARES_DEFAULT_VALUE = Flags.DECLARES_DEFAULT_VALUE;
        Intrinsics.checkNotNullExpressionValue(DECLARES_DEFAULT_VALUE, "DECLARES_DEFAULT_VALUE");
        declaresDefaultValue$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(DECLARES_DEFAULT_VALUE));
        Flags.BooleanFlagField IS_CROSSINLINE = Flags.IS_CROSSINLINE;
        Intrinsics.checkNotNullExpressionValue(IS_CROSSINLINE, "IS_CROSSINLINE");
        isCrossinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(IS_CROSSINLINE));
        Flags.BooleanFlagField IS_NOINLINE = Flags.IS_NOINLINE;
        Intrinsics.checkNotNullExpressionValue(IS_NOINLINE, "IS_NOINLINE");
        isNoinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(IS_NOINLINE));
        Flags.BooleanFlagField IS_NEGATED = Flags.IS_NEGATED;
        Intrinsics.checkNotNullExpressionValue(IS_NEGATED, "IS_NEGATED");
        isNegated$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$isNegated$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmEffectExpression) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmEffectExpression.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmEffectExpression) obj).setFlags(((Number) obj2).intValue());
            }
        }, new FlagImpl(IS_NEGATED));
        Flags.BooleanFlagField IS_NULL_CHECK_PREDICATE = Flags.IS_NULL_CHECK_PREDICATE;
        Intrinsics.checkNotNullExpressionValue(IS_NULL_CHECK_PREDICATE, "IS_NULL_CHECK_PREDICATE");
        isNullCheckPredicate$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.Attributes$isNullCheckPredicate$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmEffectExpression) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmEffectExpression.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmEffectExpression) obj).setFlags(((Number) obj2).intValue());
            }
        }, new FlagImpl(IS_NULL_CHECK_PREDICATE));
    }

    public static final boolean getHasAnnotations(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return hasAnnotations$delegate.getValue(kmClass, $$delegatedProperties[0]);
    }

    public static final void setHasAnnotations(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        hasAnnotations$delegate.setValue(kmClass, $$delegatedProperties[0], z);
    }

    public static final boolean getHasAnnotations(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        return hasAnnotations$delegate$1.getValue(kmConstructor, $$delegatedProperties[1]);
    }

    public static final void setHasAnnotations(KmConstructor kmConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        hasAnnotations$delegate$1.setValue(kmConstructor, $$delegatedProperties[1], z);
    }

    public static final boolean getHasAnnotations(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return hasAnnotations$delegate$2.getValue(kmFunction, $$delegatedProperties[2]);
    }

    public static final void setHasAnnotations(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        hasAnnotations$delegate$2.setValue(kmFunction, $$delegatedProperties[2], z);
    }

    public static final boolean getHasAnnotations(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return hasAnnotations$delegate$3.getValue(kmProperty, $$delegatedProperties[3]);
    }

    public static final void setHasAnnotations(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        hasAnnotations$delegate$3.setValue(kmProperty, $$delegatedProperties[3], z);
    }

    public static final boolean getHasAnnotations(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return hasAnnotations$delegate$4.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[4]);
    }

    public static final void setHasAnnotations(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        hasAnnotations$delegate$4.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[4], z);
    }

    public static final boolean getHasAnnotations(KmValueParameter kmValueParameter) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        return hasAnnotations$delegate$5.getValue(kmValueParameter, $$delegatedProperties[5]);
    }

    public static final void setHasAnnotations(KmValueParameter kmValueParameter, boolean z) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        hasAnnotations$delegate$5.setValue(kmValueParameter, $$delegatedProperties[5], z);
    }

    public static final boolean getHasAnnotations(KmTypeAlias kmTypeAlias) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "<this>");
        return hasAnnotations$delegate$6.getValue(kmTypeAlias, $$delegatedProperties[6]);
    }

    public static final void setHasAnnotations(KmTypeAlias kmTypeAlias, boolean z) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "<this>");
        hasAnnotations$delegate$6.setValue(kmTypeAlias, $$delegatedProperties[6], z);
    }

    public static final Modality getModality(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return (Modality) modality$delegate.getValue(kmClass, $$delegatedProperties[7]);
    }

    public static final void setModality(KmClass kmClass, Modality modality) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        Intrinsics.checkNotNullParameter(modality, "<set-?>");
        modality$delegate.setValue(kmClass, $$delegatedProperties[7], modality);
    }

    public static final Visibility getVisibility(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return (Visibility) visibility$delegate.getValue(kmClass, $$delegatedProperties[8]);
    }

    public static final void setVisibility(KmClass kmClass, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate.setValue(kmClass, $$delegatedProperties[8], visibility);
    }

    public static final ClassKind getKind(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return (ClassKind) kind$delegate.getValue(kmClass, $$delegatedProperties[9]);
    }

    public static final void setKind(KmClass kmClass, ClassKind classKind) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        Intrinsics.checkNotNullParameter(classKind, "<set-?>");
        kind$delegate.setValue(kmClass, $$delegatedProperties[9], classKind);
    }

    public static final boolean isInner(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isInner$delegate.getValue(kmClass, $$delegatedProperties[10]);
    }

    public static final void setInner(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isInner$delegate.setValue(kmClass, $$delegatedProperties[10], z);
    }

    public static final boolean isData(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isData$delegate.getValue(kmClass, $$delegatedProperties[11]);
    }

    public static final void setData(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isData$delegate.setValue(kmClass, $$delegatedProperties[11], z);
    }

    public static final boolean isExternal(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isExternal$delegate.getValue(kmClass, $$delegatedProperties[12]);
    }

    public static final void setExternal(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isExternal$delegate.setValue(kmClass, $$delegatedProperties[12], z);
    }

    public static final boolean isExpect(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isExpect$delegate.getValue(kmClass, $$delegatedProperties[13]);
    }

    public static final void setExpect(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isExpect$delegate.setValue(kmClass, $$delegatedProperties[13], z);
    }

    public static final boolean isValue(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isValue$delegate.getValue(kmClass, $$delegatedProperties[14]);
    }

    public static final void setValue(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isValue$delegate.setValue(kmClass, $$delegatedProperties[14], z);
    }

    public static final boolean isFunInterface(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isFunInterface$delegate.getValue(kmClass, $$delegatedProperties[15]);
    }

    public static final void setFunInterface(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isFunInterface$delegate.setValue(kmClass, $$delegatedProperties[15], z);
    }

    public static final boolean getHasEnumEntries(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return hasEnumEntries$delegate.getValue(kmClass, $$delegatedProperties[16]);
    }

    public static final void setHasEnumEntries(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        hasEnumEntries$delegate.setValue(kmClass, $$delegatedProperties[16], z);
    }

    public static final Visibility getVisibility(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        return (Visibility) visibility$delegate$1.getValue(kmConstructor, $$delegatedProperties[17]);
    }

    public static final void setVisibility(KmConstructor kmConstructor, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate$1.setValue(kmConstructor, $$delegatedProperties[17], visibility);
    }

    public static final boolean isSecondary(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        return isSecondary$delegate.getValue(kmConstructor, $$delegatedProperties[18]);
    }

    public static final void setSecondary(KmConstructor kmConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        isSecondary$delegate.setValue(kmConstructor, $$delegatedProperties[18], z);
    }

    public static final boolean getHasNonStableParameterNames(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        return hasNonStableParameterNames$delegate.getValue(kmConstructor, $$delegatedProperties[19]);
    }

    public static final void setHasNonStableParameterNames(KmConstructor kmConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        hasNonStableParameterNames$delegate.setValue(kmConstructor, $$delegatedProperties[19], z);
    }

    public static final MemberKind getKind(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return (MemberKind) kind$delegate$1.getValue(kmFunction, $$delegatedProperties[20]);
    }

    public static final void setKind(KmFunction kmFunction, MemberKind memberKind) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        Intrinsics.checkNotNullParameter(memberKind, "<set-?>");
        kind$delegate$1.setValue(kmFunction, $$delegatedProperties[20], memberKind);
    }

    public static final Visibility getVisibility(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return (Visibility) visibility$delegate$2.getValue(kmFunction, $$delegatedProperties[21]);
    }

    public static final void setVisibility(KmFunction kmFunction, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate$2.setValue(kmFunction, $$delegatedProperties[21], visibility);
    }

    public static final Modality getModality(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return (Modality) modality$delegate$1.getValue(kmFunction, $$delegatedProperties[22]);
    }

    public static final void setModality(KmFunction kmFunction, Modality modality) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        Intrinsics.checkNotNullParameter(modality, "<set-?>");
        modality$delegate$1.setValue(kmFunction, $$delegatedProperties[22], modality);
    }

    public static final boolean isOperator(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isOperator$delegate.getValue(kmFunction, $$delegatedProperties[23]);
    }

    public static final void setOperator(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isOperator$delegate.setValue(kmFunction, $$delegatedProperties[23], z);
    }

    public static final boolean isInfix(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isInfix$delegate.getValue(kmFunction, $$delegatedProperties[24]);
    }

    public static final void setInfix(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isInfix$delegate.setValue(kmFunction, $$delegatedProperties[24], z);
    }

    public static final boolean isInline(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isInline$delegate.getValue(kmFunction, $$delegatedProperties[25]);
    }

    public static final void setInline(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isInline$delegate.setValue(kmFunction, $$delegatedProperties[25], z);
    }

    public static final boolean isTailrec(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isTailrec$delegate.getValue(kmFunction, $$delegatedProperties[26]);
    }

    public static final void setTailrec(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isTailrec$delegate.setValue(kmFunction, $$delegatedProperties[26], z);
    }

    public static final boolean isExternal(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isExternal$delegate$1.getValue(kmFunction, $$delegatedProperties[27]);
    }

    public static final void setExternal(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isExternal$delegate$1.setValue(kmFunction, $$delegatedProperties[27], z);
    }

    public static final boolean isSuspend(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isSuspend$delegate.getValue(kmFunction, $$delegatedProperties[28]);
    }

    public static final void setSuspend(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isSuspend$delegate.setValue(kmFunction, $$delegatedProperties[28], z);
    }

    public static final boolean isExpect(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return isExpect$delegate$1.getValue(kmFunction, $$delegatedProperties[29]);
    }

    public static final void setExpect(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        isExpect$delegate$1.setValue(kmFunction, $$delegatedProperties[29], z);
    }

    public static final boolean getHasNonStableParameterNames(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return hasNonStableParameterNames$delegate$1.getValue(kmFunction, $$delegatedProperties[30]);
    }

    public static final void setHasNonStableParameterNames(KmFunction kmFunction, boolean z) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        hasNonStableParameterNames$delegate$1.setValue(kmFunction, $$delegatedProperties[30], z);
    }

    public static final Visibility getVisibility(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return (Visibility) visibility$delegate$3.getValue(kmProperty, $$delegatedProperties[31]);
    }

    public static final void setVisibility(KmProperty kmProperty, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate$3.setValue(kmProperty, $$delegatedProperties[31], visibility);
    }

    public static final Modality getModality(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return (Modality) modality$delegate$2.getValue(kmProperty, $$delegatedProperties[32]);
    }

    public static final void setModality(KmProperty kmProperty, Modality modality) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        Intrinsics.checkNotNullParameter(modality, "<set-?>");
        modality$delegate$2.setValue(kmProperty, $$delegatedProperties[32], modality);
    }

    public static final MemberKind getKind(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return (MemberKind) kind$delegate$2.getValue(kmProperty, $$delegatedProperties[33]);
    }

    public static final void setKind(KmProperty kmProperty, MemberKind memberKind) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        Intrinsics.checkNotNullParameter(memberKind, "<set-?>");
        kind$delegate$2.setValue(kmProperty, $$delegatedProperties[33], memberKind);
    }

    public static final boolean isVar(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isVar$delegate.getValue(kmProperty, $$delegatedProperties[34]);
    }

    public static final void setVar(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isVar$delegate.setValue(kmProperty, $$delegatedProperties[34], z);
    }

    public static final boolean getHasGetter(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return hasGetter$delegate.getValue(kmProperty, $$delegatedProperties[35]);
    }

    public static final void setHasGetter(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        hasGetter$delegate.setValue(kmProperty, $$delegatedProperties[35], z);
    }

    public static final boolean getHasSetter(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return hasSetter$delegate.getValue(kmProperty, $$delegatedProperties[36]);
    }

    public static final void setHasSetter(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        hasSetter$delegate.setValue(kmProperty, $$delegatedProperties[36], z);
    }

    public static final boolean isConst(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isConst$delegate.getValue(kmProperty, $$delegatedProperties[37]);
    }

    public static final void setConst(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isConst$delegate.setValue(kmProperty, $$delegatedProperties[37], z);
    }

    public static final boolean isLateinit(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isLateinit$delegate.getValue(kmProperty, $$delegatedProperties[38]);
    }

    public static final void setLateinit(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isLateinit$delegate.setValue(kmProperty, $$delegatedProperties[38], z);
    }

    public static final boolean getHasConstant(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return hasConstant$delegate.getValue(kmProperty, $$delegatedProperties[39]);
    }

    public static final void setHasConstant(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        hasConstant$delegate.setValue(kmProperty, $$delegatedProperties[39], z);
    }

    public static final boolean isExternal(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isExternal$delegate$2.getValue(kmProperty, $$delegatedProperties[40]);
    }

    public static final void setExternal(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isExternal$delegate$2.setValue(kmProperty, $$delegatedProperties[40], z);
    }

    public static final boolean isDelegated(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isDelegated$delegate.getValue(kmProperty, $$delegatedProperties[41]);
    }

    public static final void setDelegated(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isDelegated$delegate.setValue(kmProperty, $$delegatedProperties[41], z);
    }

    public static final boolean isExpect(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isExpect$delegate$2.getValue(kmProperty, $$delegatedProperties[42]);
    }

    public static final void setExpect(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isExpect$delegate$2.setValue(kmProperty, $$delegatedProperties[42], z);
    }

    public static final Visibility getVisibility(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return (Visibility) visibility$delegate$4.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[43]);
    }

    public static final void setVisibility(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate$4.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[43], visibility);
    }

    public static final Modality getModality(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return (Modality) modality$delegate$3.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[44]);
    }

    public static final void setModality(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, Modality modality) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        Intrinsics.checkNotNullParameter(modality, "<set-?>");
        modality$delegate$3.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[44], modality);
    }

    public static final boolean isNotDefault(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return isNotDefault$delegate.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[45]);
    }

    public static final void setNotDefault(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        isNotDefault$delegate.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[45], z);
    }

    public static final boolean isExternal(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return isExternal$delegate$3.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[46]);
    }

    public static final void setExternal(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        isExternal$delegate$3.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[46], z);
    }

    public static final boolean isInline(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        return isInline$delegate$1.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[47]);
    }

    public static final void setInline(KmPropertyAccessorAttributes kmPropertyAccessorAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(kmPropertyAccessorAttributes, "<this>");
        isInline$delegate$1.setValue(kmPropertyAccessorAttributes, $$delegatedProperties[47], z);
    }

    public static final boolean isNullable(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return isNullable$delegate.getValue(kmType, $$delegatedProperties[48]);
    }

    public static final void setNullable(KmType kmType, boolean z) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        isNullable$delegate.setValue(kmType, $$delegatedProperties[48], z);
    }

    public static final boolean isSuspend(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return isSuspend$delegate$1.getValue(kmType, $$delegatedProperties[49]);
    }

    public static final void setSuspend(KmType kmType, boolean z) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        isSuspend$delegate$1.setValue(kmType, $$delegatedProperties[49], z);
    }

    public static final boolean isDefinitelyNonNull(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return isDefinitelyNonNull$delegate.getValue(kmType, $$delegatedProperties[50]);
    }

    public static final void setDefinitelyNonNull(KmType kmType, boolean z) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        isDefinitelyNonNull$delegate.setValue(kmType, $$delegatedProperties[50], z);
    }

    public static final boolean isReified(KmTypeParameter kmTypeParameter) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        return isReified$delegate.getValue(kmTypeParameter, $$delegatedProperties[51]);
    }

    public static final void setReified(KmTypeParameter kmTypeParameter, boolean z) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        isReified$delegate.setValue(kmTypeParameter, $$delegatedProperties[51], z);
    }

    public static final Visibility getVisibility(KmTypeAlias kmTypeAlias) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "<this>");
        return (Visibility) visibility$delegate$5.getValue(kmTypeAlias, $$delegatedProperties[52]);
    }

    public static final void setVisibility(KmTypeAlias kmTypeAlias, Visibility visibility) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "<set-?>");
        visibility$delegate$5.setValue(kmTypeAlias, $$delegatedProperties[52], visibility);
    }

    public static final boolean getDeclaresDefaultValue(KmValueParameter kmValueParameter) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        return declaresDefaultValue$delegate.getValue(kmValueParameter, $$delegatedProperties[53]);
    }

    public static final void setDeclaresDefaultValue(KmValueParameter kmValueParameter, boolean z) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        declaresDefaultValue$delegate.setValue(kmValueParameter, $$delegatedProperties[53], z);
    }

    public static final boolean isCrossinline(KmValueParameter kmValueParameter) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        return isCrossinline$delegate.getValue(kmValueParameter, $$delegatedProperties[54]);
    }

    public static final void setCrossinline(KmValueParameter kmValueParameter, boolean z) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        isCrossinline$delegate.setValue(kmValueParameter, $$delegatedProperties[54], z);
    }

    public static final boolean isNoinline(KmValueParameter kmValueParameter) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        return isNoinline$delegate.getValue(kmValueParameter, $$delegatedProperties[55]);
    }

    public static final void setNoinline(KmValueParameter kmValueParameter, boolean z) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "<this>");
        isNoinline$delegate.setValue(kmValueParameter, $$delegatedProperties[55], z);
    }

    public static final boolean isNegated(KmEffectExpression kmEffectExpression) {
        Intrinsics.checkNotNullParameter(kmEffectExpression, "<this>");
        return isNegated$delegate.getValue(kmEffectExpression, $$delegatedProperties[56]);
    }

    public static final void setNegated(KmEffectExpression kmEffectExpression, boolean z) {
        Intrinsics.checkNotNullParameter(kmEffectExpression, "<this>");
        isNegated$delegate.setValue(kmEffectExpression, $$delegatedProperties[56], z);
    }

    public static final boolean isNullCheckPredicate(KmEffectExpression kmEffectExpression) {
        Intrinsics.checkNotNullParameter(kmEffectExpression, "<this>");
        return isNullCheckPredicate$delegate.getValue(kmEffectExpression, $$delegatedProperties[57]);
    }

    public static final void setNullCheckPredicate(KmEffectExpression kmEffectExpression, boolean z) {
        Intrinsics.checkNotNullParameter(kmEffectExpression, "<this>");
        isNullCheckPredicate$delegate.setValue(kmEffectExpression, $$delegatedProperties[57], z);
    }
}

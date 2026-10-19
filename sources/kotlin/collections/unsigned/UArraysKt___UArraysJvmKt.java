package kotlin.collections.unsigned;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UArraysJvm.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\u0000\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0000\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0000\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019*\u00020\rH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\u00020\u0011H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019*\u00020\u0015H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b \u0010!\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00022\u0006\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b&\u0010'\u001aC\u0010\"\u001a\u00020\u0004*\u00020\r2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b(\u0010)\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00112\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b*\u0010+\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00152\u0006\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b,\u0010-\u001aw\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b/\u00100\u001aw\u0010.\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b@\u0010A\u001aw\u0010.\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bB\u0010C\u001aw\u0010.\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bD\u0010E\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bY\u0010Z\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b]\u0010^\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b_\u0010`\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\ba\u0010b\u001aw\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bd\u00100\u001aw\u0010c\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bg\u0010A\u001aw\u0010c\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bh\u0010C\u001aw\u0010c\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bi\u0010E\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bk\u0010L\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bn\u0010P\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bo\u0010R\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bp\u0010T\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\br\u0010Z\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bu\u0010^\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bv\u0010`\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bw\u0010b\u001aT\u0010x\u001a\u00020y*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010{\u001aT\u0010x\u001a\u00020y*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010\u007f\u001aU\u0010x\u001a\u00020y*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0080\u0001\u001aU\u0010x\u001a\u00020y*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0081\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00022\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\r2\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00112\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00152\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0088\u0001"}, d2 = {"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", FirebaseAnalytics.Param.INDEX, "", "elementAt-qFRl0hI", "([II)I", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/internal/InlineOnly;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "Use minOrNull instead.", "this.minOrNull()", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes5.dex */
public class UArraysKt___UArraysJvmKt {
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    private static final int m10465elementAtqFRl0hI(int[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UIntArray.m10135getpVg5ArA(elementAt, i);
    }

    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    private static final long m10466elementAtr7IrZao(long[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return ULongArray.m10214getsVKNKU(elementAt, i);
    }

    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    private static final byte m10463elementAtPpDY95g(byte[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UByteArray.m10056getw2LRezQ(elementAt, i);
    }

    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    private static final short m10464elementAtnggk6HY(short[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UShortArray.m10319getMh2AYeg(elementAt, i);
    }

    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m10451asListajY9A(int[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(asList);
    }

    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m10453asListQwZRm1k(long[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(asList);
    }

    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m10452asListGBYM_sE(byte[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(asList);
    }

    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m10454asListrL5Bavg(short[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(asList);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m10456binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m10136getSizeimpl(iArr);
        }
        return UArraysKt.m10455binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m10455binarySearch2fe2U9s(int[] binarySearch, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m10136getSizeimpl(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m10460binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m10215getSizeimpl(jArr);
        }
        return UArraysKt.m10459binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m10459binarySearchK6DWlUc(long[] binarySearch, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m10215getSizeimpl(binarySearch));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(binarySearch[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else if (ulongCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m10462binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m10057getSizeimpl(bArr);
        }
        return UArraysKt.m10461binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m10461binarySearchWpHrYlw(byte[] binarySearch, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m10057getSizeimpl(binarySearch));
        int i3 = b & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m10458binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m10320getSizeimpl(sArr);
        }
        return UArraysKt.m10457binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m10457binarySearchEtDCXyQ(short[] binarySearch, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m10320getSizeimpl(binarySearch));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max--ajY-9A  reason: not valid java name */
    public static final /* synthetic */ UInt m10467maxajY9A(int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m10862maxOrNullajY9A(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-QwZRm1k  reason: not valid java name */
    public static final /* synthetic */ ULong m10469maxQwZRm1k(long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m10864maxOrNullQwZRm1k(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-GBYM_sE  reason: not valid java name */
    public static final /* synthetic */ UByte m10468maxGBYM_sE(byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m10863maxOrNullGBYM_sE(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-rL5Bavg  reason: not valid java name */
    public static final /* synthetic */ UShort m10470maxrL5Bavg(short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m10865maxOrNullrL5Bavg(max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m10473maxByjgv0xPQ(int[] maxBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m10138isEmptyimpl(maxBy)) {
            return null;
        }
        int m10135getpVg5ArA = UIntArray.m10135getpVg5ArA(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UInt.m10069boximpl(m10135getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m10069boximpl(m10135getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m10135getpVg5ArA2 = UIntArray.m10135getpVg5ArA(maxBy, i);
                R invoke2 = selector.invoke(UInt.m10069boximpl(m10135getpVg5ArA2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10135getpVg5ArA = m10135getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m10069boximpl(m10135getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m10472maxByMShoTSo(long[] maxBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m10217isEmptyimpl(maxBy)) {
            return null;
        }
        long m10214getsVKNKU = ULongArray.m10214getsVKNKU(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return ULong.m10148boximpl(m10214getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m10148boximpl(m10214getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m10214getsVKNKU2 = ULongArray.m10214getsVKNKU(maxBy, i);
                R invoke2 = selector.invoke(ULong.m10148boximpl(m10214getsVKNKU2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10214getsVKNKU = m10214getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m10148boximpl(m10214getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m10471maxByJOV_ifY(byte[] maxBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m10059isEmptyimpl(maxBy)) {
            return null;
        }
        byte m10056getw2LRezQ = UByteArray.m10056getw2LRezQ(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UByte.m9986boximpl(m10056getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m9986boximpl(m10056getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m10056getw2LRezQ2 = UByteArray.m10056getw2LRezQ(maxBy, i);
                R invoke2 = selector.invoke(UByte.m9986boximpl(m10056getw2LRezQ2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10056getw2LRezQ = m10056getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m9986boximpl(m10056getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m10474maxByxTcfx_M(short[] maxBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m10322isEmptyimpl(maxBy)) {
            return null;
        }
        short m10319getMh2AYeg = UShortArray.m10319getMh2AYeg(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UShort.m10255boximpl(m10319getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m10255boximpl(m10319getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m10319getMh2AYeg2 = UShortArray.m10319getMh2AYeg(maxBy, i);
                R invoke2 = selector.invoke(UShort.m10255boximpl(m10319getMh2AYeg2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10319getMh2AYeg = m10319getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m10255boximpl(m10319getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m10476maxWithYmdZ_VM(int[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10871maxWithOrNullYmdZ_VM(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m10478maxWithzrEWJaI(long[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10873maxWithOrNullzrEWJaI(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m10475maxWithXMRcp5o(byte[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10870maxWithOrNullXMRcp5o(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m10477maxWitheOHTfZs(short[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10872maxWithOrNulleOHTfZs(maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min--ajY-9A  reason: not valid java name */
    public static final /* synthetic */ UInt m10479minajY9A(int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m10918minOrNullajY9A(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-QwZRm1k  reason: not valid java name */
    public static final /* synthetic */ ULong m10481minQwZRm1k(long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m10920minOrNullQwZRm1k(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-GBYM_sE  reason: not valid java name */
    public static final /* synthetic */ UByte m10480minGBYM_sE(byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m10919minOrNullGBYM_sE(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-rL5Bavg  reason: not valid java name */
    public static final /* synthetic */ UShort m10482minrL5Bavg(short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m10921minOrNullrL5Bavg(min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m10485minByjgv0xPQ(int[] minBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m10138isEmptyimpl(minBy)) {
            return null;
        }
        int m10135getpVg5ArA = UIntArray.m10135getpVg5ArA(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UInt.m10069boximpl(m10135getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m10069boximpl(m10135getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m10135getpVg5ArA2 = UIntArray.m10135getpVg5ArA(minBy, i);
                R invoke2 = selector.invoke(UInt.m10069boximpl(m10135getpVg5ArA2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10135getpVg5ArA = m10135getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m10069boximpl(m10135getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m10484minByMShoTSo(long[] minBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m10217isEmptyimpl(minBy)) {
            return null;
        }
        long m10214getsVKNKU = ULongArray.m10214getsVKNKU(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return ULong.m10148boximpl(m10214getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m10148boximpl(m10214getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m10214getsVKNKU2 = ULongArray.m10214getsVKNKU(minBy, i);
                R invoke2 = selector.invoke(ULong.m10148boximpl(m10214getsVKNKU2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10214getsVKNKU = m10214getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m10148boximpl(m10214getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m10483minByJOV_ifY(byte[] minBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m10059isEmptyimpl(minBy)) {
            return null;
        }
        byte m10056getw2LRezQ = UByteArray.m10056getw2LRezQ(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UByte.m9986boximpl(m10056getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m9986boximpl(m10056getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m10056getw2LRezQ2 = UByteArray.m10056getw2LRezQ(minBy, i);
                R invoke2 = selector.invoke(UByte.m9986boximpl(m10056getw2LRezQ2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10056getw2LRezQ = m10056getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m9986boximpl(m10056getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m10486minByxTcfx_M(short[] minBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m10322isEmptyimpl(minBy)) {
            return null;
        }
        short m10319getMh2AYeg = UShortArray.m10319getMh2AYeg(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UShort.m10255boximpl(m10319getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m10255boximpl(m10319getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m10319getMh2AYeg2 = UShortArray.m10319getMh2AYeg(minBy, i);
                R invoke2 = selector.invoke(UShort.m10255boximpl(m10319getMh2AYeg2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10319getMh2AYeg = m10319getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m10255boximpl(m10319getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m10488minWithYmdZ_VM(int[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10927minWithOrNullYmdZ_VM(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m10490minWithzrEWJaI(long[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10929minWithOrNullzrEWJaI(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m10487minWithXMRcp5o(byte[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10926minWithOrNullXMRcp5o(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m10489minWitheOHTfZs(short[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m10928minWithOrNulleOHTfZs(minWith, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] sumOf, Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10136getSizeimpl = UIntArray.m10136getSizeimpl(sumOf);
        for (int i = 0; i < m10136getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m10069boximpl(UIntArray.m10135getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] sumOf, Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10215getSizeimpl = ULongArray.m10215getSizeimpl(sumOf);
        for (int i = 0; i < m10215getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m10148boximpl(ULongArray.m10214getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] sumOf, Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10057getSizeimpl = UByteArray.m10057getSizeimpl(sumOf);
        for (int i = 0; i < m10057getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m9986boximpl(UByteArray.m10056getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sumOf, Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10320getSizeimpl = UShortArray.m10320getSizeimpl(sumOf);
        for (int i = 0; i < m10320getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m10255boximpl(UShortArray.m10319getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] sumOf, Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10136getSizeimpl = UIntArray.m10136getSizeimpl(sumOf);
        for (int i = 0; i < m10136getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m10069boximpl(UIntArray.m10135getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] sumOf, Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10215getSizeimpl = ULongArray.m10215getSizeimpl(sumOf);
        for (int i = 0; i < m10215getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m10148boximpl(ULongArray.m10214getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] sumOf, Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10057getSizeimpl = UByteArray.m10057getSizeimpl(sumOf);
        for (int i = 0; i < m10057getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m9986boximpl(UByteArray.m10056getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sumOf, Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10320getSizeimpl = UShortArray.m10320getSizeimpl(sumOf);
        for (int i = 0; i < m10320getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m10255boximpl(UShortArray.m10319getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }
}

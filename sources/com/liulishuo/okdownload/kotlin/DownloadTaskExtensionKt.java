package com.liulishuo.okdownload.kotlin;

import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener1ExtensionKt;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener2ExtensionKt;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener3ExtensionKt;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener4ExtensionKt;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener4WithSpeedExtensionKt;
import com.liulishuo.okdownload.kotlin.listener.DownloadListenerExtensionKt;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
/* compiled from: DownloadTaskExtension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001aÌ\u0007\u0010\u000e\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132R\b\u0002\u0010\u0014\u001aL\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2g\b\u0002\u0010\u001b\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001` 2U\b\u0002\u0010!\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`&2@\b\u0002\u0010'\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`(2g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2U\b\u0002\u0010/\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`22U\b\u0002\u00103\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`52U\b\u0002\u00106\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`72Q\u00108\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\t0\u001cj\u0002`<\u001a¹\u0003\u0010=\u001a\u00020\t*\u00020\u00062@\b\u0002\u0010>\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110?¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`A2@\b\u0002\u0010B\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`C2j\b\u0002\u0010D\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(E\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`H2U\b\u0002\u0010I\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`J2f\u0010K\u001ab\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110?¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t0-j\u0002`L\u001a\u0086\u0001\u0010M\u001a\u00020\t*\u00020\u00062'\b\u0002\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u00132Q\u00108\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\t0\u001cj\u0002`<\u001a¨\u0004\u0010N\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010O\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`P2j\b\u0002\u0010Q\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(E\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`H2U\b\u0002\u0010R\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`J2+\b\u0002\u0010S\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`T2+\b\u0002\u0010U\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`V2+\b\u0002\u0010W\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`X2@\b\u0002\u0010Y\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`C2S\b\u0002\u0010Z\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012&\u0012$0:j\u0011`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\\¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`]2\u000e\b\u0002\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a÷\u0005\u0010_\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2j\b\u0002\u0010`\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110c¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`d2U\b\u0002\u0010e\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`g2@\b\u0002\u0010h\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`i2U\b\u0002\u0010j\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110k¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`l2{\u0010m\u001aw\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012*\u0012(\u0018\u00010:j\u0013\u0018\u0001`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110c¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t0-j\u0002`n\u001a¶\u0006\u0010o\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2j\b\u0002\u0010p\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110q¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`r2j\b\u0002\u0010s\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(f\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`v2U\b\u0002\u0010w\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`y2j\b\u0002\u0010z\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110k¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`{2{\u0010|\u001aw\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012*\u0012(\u0018\u00010:j\u0013\u0018\u0001`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\t0-j\u0002`}\u001aÌ\u0007\u0010~\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132R\b\u0002\u0010\u0014\u001aL\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2g\b\u0002\u0010\u001b\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001` 2U\b\u0002\u0010!\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`&2@\b\u0002\u0010'\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`(2g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2U\b\u0002\u0010/\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`22U\b\u0002\u00103\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`52U\b\u0002\u00106\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`72Q\u00108\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\t0\u001cj\u0002`<\u001a¹\u0003\u0010\u007f\u001a\u00020\t*\u00020\u00062@\b\u0002\u0010>\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110?¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`A2@\b\u0002\u0010B\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`C2j\b\u0002\u0010D\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(E\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`H2U\b\u0002\u0010I\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`J2f\u0010K\u001ab\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110?¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t0-j\u0002`L\u001a\u0087\u0001\u0010\u0080\u0001\u001a\u00020\t*\u00020\u00062'\b\u0002\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u00132Q\u00108\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\t0\u001cj\u0002`<\u001a©\u0004\u0010\u0081\u0001\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010O\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`P2j\b\u0002\u0010Q\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(E\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`H2U\b\u0002\u0010R\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`J2+\b\u0002\u0010S\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`T2+\b\u0002\u0010U\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`V2+\b\u0002\u0010W\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`X2@\b\u0002\u0010Y\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`C2S\b\u0002\u0010Z\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012&\u0012$0:j\u0011`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\\¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`]2\u000e\b\u0002\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001aø\u0005\u0010\u0082\u0001\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2j\b\u0002\u0010`\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110c¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`d2U\b\u0002\u0010e\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`g2@\b\u0002\u0010h\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0004\u0018\u0001`i2U\b\u0002\u0010j\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110k¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`l2{\u0010m\u001aw\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012*\u0012(\u0018\u00010:j\u0013\u0018\u0001`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110c¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t0-j\u0002`n\u001a·\u0006\u0010\u0083\u0001\u001a\u00020\t*\u00020\u00062+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132g\b\u0002\u0010)\u001aa\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`+2|\b\u0002\u0010,\u001av\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00180\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`.2j\b\u0002\u0010p\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110q¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`r2j\b\u0002\u0010s\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(f\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`v2U\b\u0002\u0010w\u001aO\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001100¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`y2j\b\u0002\u0010z\u001ad\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110k¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020\t\u0018\u00010-j\u0004\u0018\u0001`{2{\u0010|\u001aw\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0013\u0012\u001109¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012*\u0012(\u0018\u00010:j\u0013\u0018\u0001`[¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\t0-j\u0002`}\u001a\u0013\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u0001*\u00020\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0087\u0001"}, d2 = {"createReplaceListener", "Lcom/liulishuo/okdownload/DownloadListener;", "oldListener", "progressListener", "await", "Lcom/liulishuo/okdownload/kotlin/DownloadResult;", "Lcom/liulishuo/okdownload/DownloadTask;", "block", "Lkotlin/Function0;", "", "(Lcom/liulishuo/okdownload/DownloadTask;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "task", "enqueue", "onTaskStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskStart;", "onConnectTrialStart", "Lkotlin/Function2;", "", "", "", "requestHeaderFields", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectTrialStart;", "onConnectTrialEnd", "Lkotlin/Function3;", "", "responseCode", "responseHeaderFields", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectTrialEnd;", "onDownloadFromBeginning", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "cause", "Lcom/liulishuo/okdownload/kotlin/listener/onDownloadFromBeginning;", "onDownloadFromBreakpoint", "Lcom/liulishuo/okdownload/kotlin/listener/onDownloadFromBreakpoint;", "onConnectStart", "blockIndex", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectStart;", "onConnectEnd", "Lkotlin/Function4;", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectEnd;", "onFetchStart", "", "contentLength", "Lcom/liulishuo/okdownload/kotlin/listener/onFetchStart;", "onFetchProgress", "increaseBytes", "Lcom/liulishuo/okdownload/kotlin/listener/onFetchProgress;", "onFetchEnd", "Lcom/liulishuo/okdownload/kotlin/listener/onFetchEnd;", "onTaskEnd", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "Ljava/lang/Exception;", "realCause", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskEnd;", "enqueue1", "taskStart", "Lcom/liulishuo/okdownload/core/listener/assist/Listener1Assist$Listener1Model;", CommonUrlParts.MODEL, "Lcom/liulishuo/okdownload/kotlin/listener/onTaskStartWithModel;", "retry", "Lcom/liulishuo/okdownload/kotlin/listener/onRetry;", "connected", "blockCount", "currentOffset", "totalLength", "Lcom/liulishuo/okdownload/kotlin/listener/onConnected;", "progress", "Lcom/liulishuo/okdownload/kotlin/listener/onProgress;", "taskEnd", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskEndWithModel;", "enqueue2", "enqueue3", "onStarted", "Lcom/liulishuo/okdownload/kotlin/listener/onStarted;", "onConnected", "onProgress", "onCompleted", "Lcom/liulishuo/okdownload/kotlin/listener/onCompleted;", "onCanceled", "Lcom/liulishuo/okdownload/kotlin/listener/onCanceled;", "onWarn", "Lcom/liulishuo/okdownload/kotlin/listener/onWarn;", "onRetry", "onError", "Lkotlin/Exception;", "e", "Lcom/liulishuo/okdownload/kotlin/listener/onError;", "onTerminal", "enqueue4", "onInfoReady", "", "fromBreakpoint", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4Assist$Listener4Model;", "Lcom/liulishuo/okdownload/kotlin/listener/onInfoReady;", "onProgressBlock", "currentBlockOffset", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressBlock;", "onProgressWithoutTotalLength", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressWithoutTotalLength;", "onBlockEnd", "Lcom/liulishuo/okdownload/core/breakpoint/BlockInfo;", "Lcom/liulishuo/okdownload/kotlin/listener/onBlockEnd;", "onTaskEndWithListener4Model", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskEndWithListener4Model;", "enqueue4WithSpeed", "onInfoReadyWithSpeed", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4SpeedAssistExtend$Listener4SpeedModel;", "Lcom/liulishuo/okdownload/kotlin/listener/onInfoReadyWithSpeed;", "onProgressBlockWithSpeed", "Lcom/liulishuo/okdownload/SpeedCalculator;", "blockSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressBlockWithSpeed;", "onProgressWithSpeed", "taskSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressWithSpeed;", "onBlockEndWithSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onBlockEndWithSpeed;", "onTaskEndWithSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskEndWithSpeed;", "execute", "execute1", "execute2", "execute3", "execute4", "execute4WithSpeed", "spChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/liulishuo/okdownload/kotlin/DownloadProgress;", "kotlin_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class DownloadTaskExtensionKt {
    public static /* synthetic */ void execute$default(DownloadTask downloadTask, Function1 function1, Function2 function2, Function3 function3, Function3 function32, Function2 function22, Function3 function33, Function4 function4, Function3 function34, Function3 function35, Function3 function36, Function3 function37, int i, Object obj) {
        Function3 function38;
        Function3 function39;
        Function3 function310;
        Function3 function311;
        Function3 function312;
        Function4 function42;
        Function3 function313;
        Function2 function23;
        Function2 function24;
        Function3 function314;
        DownloadTask downloadTask2;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function32 = null;
        }
        if ((i & 16) != 0) {
            function22 = null;
        }
        if ((i & 32) != 0) {
            function33 = null;
        }
        if ((i & 64) != 0) {
            function4 = null;
        }
        if ((i & 128) != 0) {
            function34 = null;
        }
        if ((i & 256) != 0) {
            function35 = null;
        }
        if ((i & 512) != 0) {
            function38 = null;
            function310 = function34;
            function39 = function37;
            function312 = function33;
            function311 = function35;
            function313 = function32;
            function42 = function4;
            function24 = function2;
            function23 = function22;
            downloadTask2 = downloadTask;
            function314 = function3;
        } else {
            function38 = function36;
            function39 = function37;
            function310 = function34;
            function311 = function35;
            function312 = function33;
            function42 = function4;
            function313 = function32;
            function23 = function22;
            function24 = function2;
            function314 = function3;
            downloadTask2 = downloadTask;
        }
        execute(downloadTask2, function1, function24, function314, function313, function23, function312, function42, function310, function311, function38, function39);
    }

    public static final void execute(DownloadTask execute, Function1<? super DownloadTask, Unit> function1, Function2<? super DownloadTask, ? super Map<String, ? extends List<String>>, Unit> function2, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function3<? super DownloadTask, ? super BreakpointInfo, ? super ResumeFailedCause, Unit> function32, Function2<? super DownloadTask, ? super BreakpointInfo, Unit> function22, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function33, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function34, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function35, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function36, Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkParameterIsNotNull(execute, "$this$execute");
        Intrinsics.checkParameterIsNotNull(onTaskEnd, "onTaskEnd");
        execute.execute(DownloadListenerExtensionKt.createListener(function1, function2, function3, function32, function22, function33, function4, function34, function35, function36, onTaskEnd));
    }

    public static /* synthetic */ void execute1$default(DownloadTask downloadTask, Function2 function2, Function2 function22, Function4 function4, Function3 function3, Function4 function42, int i, Object obj) {
        Function3 function32;
        Function4 function43;
        Function2 function23;
        Function4 function44;
        DownloadTask downloadTask2;
        if ((i & 1) != 0) {
            function2 = null;
        }
        if ((i & 2) != 0) {
            function22 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function32 = null;
            function23 = function22;
            function43 = function42;
            downloadTask2 = downloadTask;
            function44 = function4;
        } else {
            function32 = function3;
            function43 = function42;
            function23 = function22;
            function44 = function4;
            downloadTask2 = downloadTask;
        }
        execute1(downloadTask2, function2, function23, function44, function32, function43);
    }

    public static final void execute1(DownloadTask execute1, Function2<? super DownloadTask, ? super Listener1Assist.Listener1Model, Unit> function2, Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function22, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener1Assist.Listener1Model, Unit> taskEnd) {
        Intrinsics.checkParameterIsNotNull(execute1, "$this$execute1");
        Intrinsics.checkParameterIsNotNull(taskEnd, "taskEnd");
        execute1.execute(DownloadListener1ExtensionKt.createListener1(function2, function22, function4, function3, taskEnd));
    }

    public static /* synthetic */ void execute2$default(DownloadTask downloadTask, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<DownloadTask, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$execute2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2) {
                    invoke2(downloadTask2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadTask it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
        }
        execute2(downloadTask, function1, function3);
    }

    public static final void execute2(DownloadTask execute2, Function1<? super DownloadTask, Unit> onTaskStart, Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkParameterIsNotNull(execute2, "$this$execute2");
        Intrinsics.checkParameterIsNotNull(onTaskStart, "onTaskStart");
        Intrinsics.checkParameterIsNotNull(onTaskEnd, "onTaskEnd");
        execute2.execute(DownloadListener2ExtensionKt.createListener2(onTaskStart, onTaskEnd));
    }

    public static /* synthetic */ void execute3$default(DownloadTask downloadTask, Function1 function1, Function4 function4, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function2 function22, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function4 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        if ((i & 16) != 0) {
            function13 = null;
        }
        if ((i & 32) != 0) {
            function14 = null;
        }
        if ((i & 64) != 0) {
            function2 = null;
        }
        if ((i & 128) != 0) {
            function22 = null;
        }
        if ((i & 256) != 0) {
            function0 = new Function0<Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$execute3$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Function2 function23 = function22;
        Function0 function02 = function0;
        Function2 function24 = function2;
        Function1 function15 = function13;
        Function3 function32 = function3;
        Function1 function16 = function1;
        execute3(downloadTask, function16, function4, function32, function12, function15, function14, function24, function23, function02);
    }

    public static final void execute3(DownloadTask execute3, Function1<? super DownloadTask, Unit> function1, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, Function1<? super DownloadTask, Unit> function12, Function1<? super DownloadTask, Unit> function13, Function1<? super DownloadTask, Unit> function14, Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function2, Function2<? super DownloadTask, ? super Exception, Unit> function22, Function0<Unit> onTerminal) {
        Intrinsics.checkParameterIsNotNull(execute3, "$this$execute3");
        Intrinsics.checkParameterIsNotNull(onTerminal, "onTerminal");
        execute3.execute(DownloadListener3ExtensionKt.createListener3(function1, function4, function3, function12, function13, function14, function2, function22, onTerminal));
    }

    public static /* synthetic */ void execute4$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function3 function32, Function2 function2, Function3 function33, Function4 function43, int i, Object obj) {
        Function3 function34;
        Function4 function44;
        Function3 function35;
        Function2 function22;
        Function4 function45;
        Function4 function46;
        Function1 function12;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function3 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function42 = null;
        }
        if ((i & 16) != 0) {
            function32 = null;
        }
        if ((i & 32) != 0) {
            function2 = null;
        }
        if ((i & 64) != 0) {
            function34 = null;
            function35 = function32;
            function44 = function43;
            function45 = function4;
            function22 = function2;
            function12 = function1;
            function46 = function42;
        } else {
            function34 = function33;
            function44 = function43;
            function35 = function32;
            function22 = function2;
            function45 = function4;
            function46 = function42;
            function12 = function1;
        }
        execute4(downloadTask, function12, function3, function45, function46, function35, function22, function34, function44);
    }

    public static final void execute4(DownloadTask execute4, Function1<? super DownloadTask, Unit> function1, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4Assist.Listener4Model, Unit> function42, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function32, Function2<? super DownloadTask, ? super Long, Unit> function2, Function3<? super DownloadTask, ? super Integer, ? super BlockInfo, Unit> function33, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener4Assist.Listener4Model, Unit> onTaskEndWithListener4Model) {
        Intrinsics.checkParameterIsNotNull(execute4, "$this$execute4");
        Intrinsics.checkParameterIsNotNull(onTaskEndWithListener4Model, "onTaskEndWithListener4Model");
        execute4.execute(DownloadListener4ExtensionKt.createListener4(function1, function3, function4, function42, function32, function2, function33, onTaskEndWithListener4Model));
    }

    public static /* synthetic */ void execute4WithSpeed$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i, Object obj) {
        Function4 function46;
        Function4 function47;
        Function4 function48;
        Function3 function33;
        Function4 function49;
        Function4 function410;
        Function1 function12;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function3 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function42 = null;
        }
        if ((i & 16) != 0) {
            function43 = null;
        }
        if ((i & 32) != 0) {
            function32 = null;
        }
        if ((i & 64) != 0) {
            function46 = null;
            function48 = function43;
            function47 = function45;
            function49 = function4;
            function33 = function32;
            function12 = function1;
            function410 = function42;
        } else {
            function46 = function44;
            function47 = function45;
            function48 = function43;
            function33 = function32;
            function49 = function4;
            function410 = function42;
            function12 = function1;
        }
        execute4WithSpeed(downloadTask, function12, function3, function49, function410, function48, function33, function46, function47);
    }

    public static final void execute4WithSpeed(DownloadTask execute4WithSpeed, Function1<? super DownloadTask, Unit> function1, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkParameterIsNotNull(execute4WithSpeed, "$this$execute4WithSpeed");
        Intrinsics.checkParameterIsNotNull(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        execute4WithSpeed.execute(DownloadListener4WithSpeedExtensionKt.createListener4WithSpeed(function1, function3, function4, function42, function43, function32, function44, onTaskEndWithSpeed));
    }

    public static /* synthetic */ void enqueue$default(DownloadTask downloadTask, Function1 function1, Function2 function2, Function3 function3, Function3 function32, Function2 function22, Function3 function33, Function4 function4, Function3 function34, Function3 function35, Function3 function36, Function3 function37, int i, Object obj) {
        Function3 function38;
        Function3 function39;
        Function3 function310;
        Function3 function311;
        Function3 function312;
        Function4 function42;
        Function3 function313;
        Function2 function23;
        Function2 function24;
        Function3 function314;
        DownloadTask downloadTask2;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function32 = null;
        }
        if ((i & 16) != 0) {
            function22 = null;
        }
        if ((i & 32) != 0) {
            function33 = null;
        }
        if ((i & 64) != 0) {
            function4 = null;
        }
        if ((i & 128) != 0) {
            function34 = null;
        }
        if ((i & 256) != 0) {
            function35 = null;
        }
        if ((i & 512) != 0) {
            function38 = null;
            function310 = function34;
            function39 = function37;
            function312 = function33;
            function311 = function35;
            function313 = function32;
            function42 = function4;
            function24 = function2;
            function23 = function22;
            downloadTask2 = downloadTask;
            function314 = function3;
        } else {
            function38 = function36;
            function39 = function37;
            function310 = function34;
            function311 = function35;
            function312 = function33;
            function42 = function4;
            function313 = function32;
            function23 = function22;
            function24 = function2;
            function314 = function3;
            downloadTask2 = downloadTask;
        }
        enqueue(downloadTask2, function1, function24, function314, function313, function23, function312, function42, function310, function311, function38, function39);
    }

    public static final void enqueue(DownloadTask enqueue, Function1<? super DownloadTask, Unit> function1, Function2<? super DownloadTask, ? super Map<String, ? extends List<String>>, Unit> function2, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function3<? super DownloadTask, ? super BreakpointInfo, ? super ResumeFailedCause, Unit> function32, Function2<? super DownloadTask, ? super BreakpointInfo, Unit> function22, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function33, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function34, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function35, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function36, Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkParameterIsNotNull(enqueue, "$this$enqueue");
        Intrinsics.checkParameterIsNotNull(onTaskEnd, "onTaskEnd");
        enqueue.enqueue(DownloadListenerExtensionKt.createListener(function1, function2, function3, function32, function22, function33, function4, function34, function35, function36, onTaskEnd));
    }

    public static /* synthetic */ void enqueue1$default(DownloadTask downloadTask, Function2 function2, Function2 function22, Function4 function4, Function3 function3, Function4 function42, int i, Object obj) {
        Function3 function32;
        Function4 function43;
        Function2 function23;
        Function4 function44;
        DownloadTask downloadTask2;
        if ((i & 1) != 0) {
            function2 = null;
        }
        if ((i & 2) != 0) {
            function22 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function32 = null;
            function23 = function22;
            function43 = function42;
            downloadTask2 = downloadTask;
            function44 = function4;
        } else {
            function32 = function3;
            function43 = function42;
            function23 = function22;
            function44 = function4;
            downloadTask2 = downloadTask;
        }
        enqueue1(downloadTask2, function2, function23, function44, function32, function43);
    }

    public static final void enqueue1(DownloadTask enqueue1, Function2<? super DownloadTask, ? super Listener1Assist.Listener1Model, Unit> function2, Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function22, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener1Assist.Listener1Model, Unit> taskEnd) {
        Intrinsics.checkParameterIsNotNull(enqueue1, "$this$enqueue1");
        Intrinsics.checkParameterIsNotNull(taskEnd, "taskEnd");
        enqueue1.enqueue(DownloadListener1ExtensionKt.createListener1(function2, function22, function4, function3, taskEnd));
    }

    public static /* synthetic */ void enqueue2$default(DownloadTask downloadTask, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<DownloadTask, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$enqueue2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2) {
                    invoke2(downloadTask2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadTask it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
        }
        enqueue2(downloadTask, function1, function3);
    }

    public static final void enqueue2(DownloadTask enqueue2, Function1<? super DownloadTask, Unit> onTaskStart, Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkParameterIsNotNull(enqueue2, "$this$enqueue2");
        Intrinsics.checkParameterIsNotNull(onTaskStart, "onTaskStart");
        Intrinsics.checkParameterIsNotNull(onTaskEnd, "onTaskEnd");
        enqueue2.enqueue(DownloadListener2ExtensionKt.createListener2(onTaskStart, onTaskEnd));
    }

    public static /* synthetic */ void enqueue3$default(DownloadTask downloadTask, Function1 function1, Function4 function4, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function2 function22, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function4 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        if ((i & 16) != 0) {
            function13 = null;
        }
        if ((i & 32) != 0) {
            function14 = null;
        }
        if ((i & 64) != 0) {
            function2 = null;
        }
        if ((i & 128) != 0) {
            function22 = null;
        }
        if ((i & 256) != 0) {
            function0 = new Function0<Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$enqueue3$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Function2 function23 = function22;
        Function0 function02 = function0;
        Function2 function24 = function2;
        Function1 function15 = function13;
        Function3 function32 = function3;
        Function1 function16 = function1;
        enqueue3(downloadTask, function16, function4, function32, function12, function15, function14, function24, function23, function02);
    }

    public static final void enqueue3(DownloadTask enqueue3, Function1<? super DownloadTask, Unit> function1, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, Function1<? super DownloadTask, Unit> function12, Function1<? super DownloadTask, Unit> function13, Function1<? super DownloadTask, Unit> function14, Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function2, Function2<? super DownloadTask, ? super Exception, Unit> function22, Function0<Unit> onTerminal) {
        Intrinsics.checkParameterIsNotNull(enqueue3, "$this$enqueue3");
        Intrinsics.checkParameterIsNotNull(onTerminal, "onTerminal");
        enqueue3.enqueue(DownloadListener3ExtensionKt.createListener3(function1, function4, function3, function12, function13, function14, function2, function22, onTerminal));
    }

    public static /* synthetic */ void enqueue4$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function3 function32, Function2 function2, Function3 function33, Function4 function43, int i, Object obj) {
        Function3 function34;
        Function4 function44;
        Function3 function35;
        Function2 function22;
        Function4 function45;
        Function4 function46;
        Function1 function12;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function3 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function42 = null;
        }
        if ((i & 16) != 0) {
            function32 = null;
        }
        if ((i & 32) != 0) {
            function2 = null;
        }
        if ((i & 64) != 0) {
            function34 = null;
            function35 = function32;
            function44 = function43;
            function45 = function4;
            function22 = function2;
            function12 = function1;
            function46 = function42;
        } else {
            function34 = function33;
            function44 = function43;
            function35 = function32;
            function22 = function2;
            function45 = function4;
            function46 = function42;
            function12 = function1;
        }
        enqueue4(downloadTask, function12, function3, function45, function46, function35, function22, function34, function44);
    }

    public static final void enqueue4(DownloadTask enqueue4, Function1<? super DownloadTask, Unit> function1, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4Assist.Listener4Model, Unit> function42, Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function32, Function2<? super DownloadTask, ? super Long, Unit> function2, Function3<? super DownloadTask, ? super Integer, ? super BlockInfo, Unit> function33, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener4Assist.Listener4Model, Unit> onTaskEndWithListener4Model) {
        Intrinsics.checkParameterIsNotNull(enqueue4, "$this$enqueue4");
        Intrinsics.checkParameterIsNotNull(onTaskEndWithListener4Model, "onTaskEndWithListener4Model");
        enqueue4.enqueue(DownloadListener4ExtensionKt.createListener4(function1, function3, function4, function42, function32, function2, function33, onTaskEndWithListener4Model));
    }

    public static /* synthetic */ void enqueue4WithSpeed$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i, Object obj) {
        Function4 function46;
        Function4 function47;
        Function4 function48;
        Function3 function33;
        Function4 function49;
        Function4 function410;
        Function1 function12;
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function3 = null;
        }
        if ((i & 4) != 0) {
            function4 = null;
        }
        if ((i & 8) != 0) {
            function42 = null;
        }
        if ((i & 16) != 0) {
            function43 = null;
        }
        if ((i & 32) != 0) {
            function32 = null;
        }
        if ((i & 64) != 0) {
            function46 = null;
            function48 = function43;
            function47 = function45;
            function49 = function4;
            function33 = function32;
            function12 = function1;
            function410 = function42;
        } else {
            function46 = function44;
            function47 = function45;
            function48 = function43;
            function33 = function32;
            function49 = function4;
            function410 = function42;
            function12 = function1;
        }
        enqueue4WithSpeed(downloadTask, function12, function3, function49, function410, function48, function33, function46, function47);
    }

    public static final void enqueue4WithSpeed(DownloadTask enqueue4WithSpeed, Function1<? super DownloadTask, Unit> function1, Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkParameterIsNotNull(enqueue4WithSpeed, "$this$enqueue4WithSpeed");
        Intrinsics.checkParameterIsNotNull(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        enqueue4WithSpeed.enqueue(DownloadListener4WithSpeedExtensionKt.createListener4WithSpeed(function1, function3, function4, function42, function43, function32, function44, onTaskEndWithSpeed));
    }

    public static final Channel<DownloadProgress> spChannel(DownloadTask spChannel) {
        Intrinsics.checkParameterIsNotNull(spChannel, "$this$spChannel");
        final Channel<DownloadProgress> Channel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
        DownloadListener listener = spChannel.getListener();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        DownloadListener1 createListener1$default = DownloadListener1ExtensionKt.createListener1$default(null, null, null, new Function3<DownloadTask, Long, Long, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$spChannel$progressListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Long l, Long l2) {
                invoke(downloadTask, l.longValue(), l2.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, long j, long j2) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                if (atomicBoolean.get()) {
                    return;
                }
                Channel$default.offer(new DownloadProgress(task, j, j2));
            }
        }, new Function4<DownloadTask, EndCause, Exception, Listener1Assist.Listener1Model, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$spChannel$progressListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Assist.Listener1Model listener1Model) {
                invoke2(downloadTask, endCause, exc, listener1Model);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Assist.Listener1Model listener1Model) {
                Intrinsics.checkParameterIsNotNull(downloadTask, "<anonymous parameter 0>");
                Intrinsics.checkParameterIsNotNull(endCause, "<anonymous parameter 1>");
                Intrinsics.checkParameterIsNotNull(listener1Model, "<anonymous parameter 3>");
                atomicBoolean.set(true);
                SendChannel.DefaultImpls.close$default(Channel$default, null, 1, null);
            }
        }, 7, null);
        createListener1$default.setAlwaysRecoverAssistModelIfNotSet(true);
        spChannel.replaceListener(createReplaceListener(listener, createListener1$default));
        return Channel$default;
    }

    public static final DownloadListener createReplaceListener(DownloadListener downloadListener, final DownloadListener progressListener) {
        Intrinsics.checkParameterIsNotNull(progressListener, "progressListener");
        if (downloadListener == null) {
            return progressListener;
        }
        final DownloadListener switchToExceptProgressListener = DownloadListenerExtensionKt.switchToExceptProgressListener(downloadListener);
        return DownloadListenerExtensionKt.createListener(new Function1<DownloadTask, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask) {
                invoke2(downloadTask);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                DownloadListener.this.taskStart(it);
                progressListener.taskStart(it);
            }
        }, new Function2<DownloadTask, Map<String, ? extends List<? extends String>>, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Map<String, ? extends List<? extends String>> map) {
                invoke2(downloadTask, (Map<String, ? extends List<String>>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask task, Map<String, ? extends List<String>> requestFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(requestFields, "requestFields");
                DownloadListener.this.connectTrialStart(task, requestFields);
            }
        }, new Function3<DownloadTask, Integer, Map<String, ? extends List<? extends String>>, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Map<String, ? extends List<? extends String>> map) {
                invoke(downloadTask, num.intValue(), (Map<String, ? extends List<String>>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, Map<String, ? extends List<String>> responseHeaderFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(responseHeaderFields, "responseHeaderFields");
                DownloadListener.this.connectTrialEnd(task, i, responseHeaderFields);
            }
        }, new Function3<DownloadTask, BreakpointInfo, ResumeFailedCause, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
                invoke2(downloadTask, breakpointInfo, resumeFailedCause);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(info, "info");
                Intrinsics.checkParameterIsNotNull(cause, "cause");
                DownloadListener.this.downloadFromBeginning(task, info, cause);
                progressListener.downloadFromBeginning(task, info, cause);
            }
        }, new Function2<DownloadTask, BreakpointInfo, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
                invoke2(downloadTask, breakpointInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask task, BreakpointInfo info) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(info, "info");
                DownloadListener.this.downloadFromBreakpoint(task, info);
                progressListener.downloadFromBreakpoint(task, info);
            }
        }, new Function3<DownloadTask, Integer, Map<String, ? extends List<? extends String>>, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Map<String, ? extends List<? extends String>> map) {
                invoke(downloadTask, num.intValue(), (Map<String, ? extends List<String>>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, Map<String, ? extends List<String>> requestHeaderFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(requestHeaderFields, "requestHeaderFields");
                DownloadListener.this.connectStart(task, i, requestHeaderFields);
            }
        }, new Function4<DownloadTask, Integer, Integer, Map<String, ? extends List<? extends String>>, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Integer num2, Map<String, ? extends List<? extends String>> map) {
                invoke(downloadTask, num.intValue(), num2.intValue(), (Map<String, ? extends List<String>>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, int i2, Map<String, ? extends List<String>> responseHeaderFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(responseHeaderFields, "responseHeaderFields");
                DownloadListener.this.connectEnd(task, i, i2, responseHeaderFields);
            }
        }, new Function3<DownloadTask, Integer, Long, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Long l) {
                invoke(downloadTask, num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, long j) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                DownloadListener.this.fetchStart(task, i, j);
            }
        }, new Function3<DownloadTask, Integer, Long, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Long l) {
                invoke(downloadTask, num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, long j) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                DownloadListener.this.fetchProgress(task, i, j);
            }
        }, new Function3<DownloadTask, Integer, Long, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, Integer num, Long l) {
                invoke(downloadTask, num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(DownloadTask task, int i, long j) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                DownloadListener.this.fetchEnd(task, i, j);
            }
        }, new Function3<DownloadTask, EndCause, Exception, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$createReplaceListener$11
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask, EndCause endCause, Exception exc) {
                invoke2(downloadTask, endCause, exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask task, EndCause cause, Exception exc) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(cause, "cause");
                DownloadListener.this.taskEnd(task, cause, exc);
                progressListener.taskEnd(task, cause, exc);
            }
        });
    }

    public static final void cancelDownloadOnCancellation(CancellableContinuation<?> cancelDownloadOnCancellation, final DownloadTask task) {
        Intrinsics.checkParameterIsNotNull(cancelDownloadOnCancellation, "$this$cancelDownloadOnCancellation");
        Intrinsics.checkParameterIsNotNull(task, "task");
        cancelDownloadOnCancellation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$cancelDownloadOnCancellation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                DownloadTask.this.cancel();
            }
        });
    }

    public static /* synthetic */ Object await$default(DownloadTask downloadTask, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$await$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        return await(downloadTask, function0, continuation);
    }

    public static final Object await(final DownloadTask downloadTask, final Function0<Unit> function0, Continuation<? super DownloadResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        downloadTask.enqueue(DownloadListener2ExtensionKt.createListener2(new Function1<DownloadTask, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$await$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2) {
                invoke2(downloadTask2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                DownloadTaskExtensionKt.cancelDownloadOnCancellation(CancellableContinuation.this, downloadTask);
            }
        }, new Function3<DownloadTask, EndCause, Exception, Unit>() { // from class: com.liulishuo.okdownload.kotlin.DownloadTaskExtensionKt$await$3$listener2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2, EndCause endCause, Exception exc) {
                invoke2(downloadTask2, endCause, exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask downloadTask2, EndCause cause, Exception exc) {
                Intrinsics.checkParameterIsNotNull(downloadTask2, "<anonymous parameter 0>");
                Intrinsics.checkParameterIsNotNull(cause, "cause");
                if (exc != null) {
                    Result.Companion companion = Result.Companion;
                    CancellableContinuation.this.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(exc)));
                    return;
                }
                DownloadResult downloadResult = new DownloadResult(cause);
                Result.Companion companion2 = Result.Companion;
                CancellableContinuation.this.resumeWith(Result.m8443constructorimpl(downloadResult));
            }
        }));
        function0.invoke();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

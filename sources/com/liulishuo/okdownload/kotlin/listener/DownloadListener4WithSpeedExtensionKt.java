package com.liulishuo.okdownload.kotlin.listener;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.DownloadListener4WithSpeed;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadListener4WithSpeedExtension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a²\u0006\u0010\u0000\u001a\u00020\u00012+\b\u0002\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t2g\b\u0002\u0010\n\u001aa\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00100\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\u0004\u0018\u0001`\u00122|\b\u0002\u0010\u0013\u001av\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00100\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00172j\b\u0002\u0010\u0018\u001ad\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u001f2j\b\u0002\u0010 \u001ad\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`%2U\b\u0002\u0010&\u001aO\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b('\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\u0004\u0018\u0001`)2j\b\u0002\u0010*\u001ad\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`,2{\u0010-\u001aw\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(/\u0012*\u0012(\u0018\u000100j\u0013\u0018\u0001`1¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(2¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b0\u0014j\u0002`3*¾\u0001\u0010*\"\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u00142\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u0014*¾\u0001\u0010\u0018\"\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u00142\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0014*¾\u0001\u0010 \"\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u00142\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u0014*\u0094\u0001\u0010&\"G\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b('\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b0\u000b2G\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b('\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b0\u000b*×\u0001\u0010-\"^\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u0001`1¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b0\u00142s\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(/\u0012*\u0012(\u0018\u000100j\u0013\u0018\u0001`1¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(2¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b0\u0014¨\u00064"}, d2 = {"createListener4WithSpeed", "Lcom/liulishuo/okdownload/core/listener/DownloadListener4WithSpeed;", "onTaskStart", "Lkotlin/Function1;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskStart;", "onConnectStart", "Lkotlin/Function3;", "", "blockIndex", "", "", "", "requestHeaderFields", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectStart;", "onConnectEnd", "Lkotlin/Function4;", "responseCode", "responseHeaderFields", "Lcom/liulishuo/okdownload/kotlin/listener/onConnectEnd;", "onInfoReadyWithSpeed", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "", "fromBreakpoint", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4SpeedAssistExtend$Listener4SpeedModel;", CommonUrlParts.MODEL, "Lcom/liulishuo/okdownload/kotlin/listener/onInfoReadyWithSpeed;", "onProgressBlockWithSpeed", "", "currentBlockOffset", "Lcom/liulishuo/okdownload/SpeedCalculator;", "blockSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressBlockWithSpeed;", "onProgressWithSpeed", "currentOffset", "taskSpeed", "Lcom/liulishuo/okdownload/kotlin/listener/onProgressWithSpeed;", "onBlockEndWithSpeed", "Lcom/liulishuo/okdownload/core/breakpoint/BlockInfo;", "Lcom/liulishuo/okdownload/kotlin/listener/onBlockEndWithSpeed;", "onTaskEndWithSpeed", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "realCause", "Lcom/liulishuo/okdownload/kotlin/listener/onTaskEndWithSpeed;", "kotlin_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class DownloadListener4WithSpeedExtensionKt {
    public static /* synthetic */ DownloadListener4WithSpeed createListener4WithSpeed$default(Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i, Object obj) {
        Function4 function46;
        Function4 function47;
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
            function46 = function45;
            function47 = null;
        } else {
            function46 = function45;
            function47 = function44;
        }
        Function3 function33 = function32;
        Function4 function48 = function43;
        Function4 function49 = function42;
        return createListener4WithSpeed(function1, function3, function4, function49, function48, function33, function47, function46);
    }

    public static final DownloadListener4WithSpeed createListener4WithSpeed(final Function1<? super DownloadTask, Unit> function1, final Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, final Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, final Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, final Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, final Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, final Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, final Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkParameterIsNotNull(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        return new DownloadListener4WithSpeed() { // from class: com.liulishuo.okdownload.kotlin.listener.DownloadListener4WithSpeedExtensionKt$createListener4WithSpeed$1
            @Override // com.liulishuo.okdownload.DownloadListener
            public void taskStart(DownloadTask task) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Function1 function12 = Function1.this;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(task);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void infoReady(DownloadTask task, BreakpointInfo info, boolean z, Listener4SpeedAssistExtend.Listener4SpeedModel model) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(info, "info");
                Intrinsics.checkParameterIsNotNull(model, "model");
                Function4 function45 = function42;
                if (function45 != null) {
                    Unit unit = (Unit) function45.invoke(task, info, Boolean.valueOf(z), model);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void progressBlock(DownloadTask task, int i, long j, SpeedCalculator blockSpeed) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(blockSpeed, "blockSpeed");
                Function4 function45 = function43;
                if (function45 != null) {
                    Unit unit = (Unit) function45.invoke(task, Integer.valueOf(i), Long.valueOf(j), blockSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void progress(DownloadTask task, long j, SpeedCalculator taskSpeed) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(taskSpeed, "taskSpeed");
                Function3 function33 = function32;
                if (function33 != null) {
                    Unit unit = (Unit) function33.invoke(task, Long.valueOf(j), taskSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void blockEnd(DownloadTask task, int i, BlockInfo info, SpeedCalculator blockSpeed) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(info, "info");
                Intrinsics.checkParameterIsNotNull(blockSpeed, "blockSpeed");
                Function4 function45 = function44;
                if (function45 != null) {
                    Unit unit = (Unit) function45.invoke(task, Integer.valueOf(i), info, blockSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void taskEnd(DownloadTask task, EndCause cause, Exception exc, SpeedCalculator taskSpeed) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(cause, "cause");
                Intrinsics.checkParameterIsNotNull(taskSpeed, "taskSpeed");
                onTaskEndWithSpeed.invoke(task, cause, exc, taskSpeed);
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectStart(DownloadTask task, int i, Map<String, List<String>> requestHeaderFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(requestHeaderFields, "requestHeaderFields");
                Function3 function33 = function3;
                if (function33 != null) {
                    Unit unit = (Unit) function33.invoke(task, Integer.valueOf(i), requestHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectEnd(DownloadTask task, int i, int i2, Map<String, List<String>> responseHeaderFields) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                Intrinsics.checkParameterIsNotNull(responseHeaderFields, "responseHeaderFields");
                Function4 function45 = function4;
                if (function45 != null) {
                    Unit unit = (Unit) function45.invoke(task, Integer.valueOf(i), Integer.valueOf(i2), responseHeaderFields);
                }
            }
        };
    }
}

package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
/* compiled from: LocationOn.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_locationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOn", "Landroidx/compose/material/icons/Icons$Filled;", "getLocationOn", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocationOnKt {
    private static ImageVector _locationOn;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getParentInsn()" because "reg" is null
        	at jadx.core.dex.instructions.args.SSAVar.updateUsedInPhiList(SSAVar.java:152)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:482)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:484)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1079)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1088)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:115)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	... 1 more
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getLocationOn(androidx.compose.material.icons.Icons.Filled r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.filled.LocationOnKt._locationOn
            if (r0 == 0) goto L8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        L8:
            androidx.compose.ui.graphics.vector.ImageVector$Builder r1 = new androidx.compose.ui.graphics.vector.ImageVector$Builder
            r0 = 1103101952(0x41c00000, float:24.0)
            float r3 = androidx.compose.ui.unit.Dp.m7251constructorimpl(r0)
            float r4 = androidx.compose.ui.unit.Dp.m7251constructorimpl(r0)
            r11 = 96
            r12 = 0
            java.lang.String r2 = "Filled.LocationOn"
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r10 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            int r3 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m4563getBlack0d7_KjU()
            r2 = 0
            r0.<init>(r4, r2)
            r5 = r0
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r10 = r0.m4907getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r0 = androidx.compose.ui.graphics.StrokeJoin.Companion
            int r11 = r0.m4917getBevelLxFBmk8()
            androidx.compose.ui.graphics.vector.PathBuilder r12 = new androidx.compose.ui.graphics.vector.PathBuilder
            r12.<init>()
            r0 = 1073741824(0x40000000, float:2.0)
            r2 = 1094713344(0x41400000, float:12.0)
            r12.moveTo(r2, r0)
            r17 = 1084227584(0x40a00000, float:5.0)
            r18 = 1091567616(0x41100000, float:9.0)
            r13 = 1090655355(0x4102147b, float:8.13)
            r14 = 1073741824(0x40000000, float:2.0)
            r15 = 1084227584(0x40a00000, float:5.0)
            r16 = 1084500214(0x40a428f6, float:5.13)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r17 = 1088421888(0x40e00000, float:7.0)
            r18 = 1095761920(0x41500000, float:13.0)
            r13 = 0
            r14 = 1084751872(0x40a80000, float:5.25)
            r15 = 1088421888(0x40e00000, float:7.0)
            r16 = 1095761920(0x41500000, float:13.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1057488896(0xffffffffc0f80000, float:-7.75)
            r4 = -1051721728(0xffffffffc1500000, float:-13.0)
            r6 = 1088421888(0x40e00000, float:7.0)
            r12.reflectiveCurveToRelative(r6, r0, r6, r4)
            r17 = -1059061760(0xffffffffc0e00000, float:-7.0)
            r18 = -1059061760(0xffffffffc0e00000, float:-7.0)
            r14 = -1065898476(0xffffffffc077ae14, float:-3.87)
            r15 = -1069002260(0xffffffffc04851ec, float:-3.13)
            r16 = -1059061760(0xffffffffc0e00000, float:-7.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            r0 = 1094189056(0x41380000, float:11.5)
            r12.moveTo(r2, r0)
            r17 = -1071644672(0xffffffffc0200000, float:-2.5)
            r18 = -1071644672(0xffffffffc0200000, float:-2.5)
            r13 = -1078942761(0xffffffffbfb0a3d7, float:-1.38)
            r14 = 0
            r15 = -1071644672(0xffffffffc0200000, float:-2.5)
            r16 = -1081123799(0xffffffffbf8f5c29, float:-1.12)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1066359849(0x3f8f5c29, float:1.12)
            r2 = -1071644672(0xffffffffc0200000, float:-2.5)
            r4 = 1075838976(0x40200000, float:2.5)
            r12.reflectiveCurveToRelative(r0, r2, r4, r2)
            r12.reflectiveCurveToRelative(r4, r0, r4, r4)
            r0 = -1081123799(0xffffffffbf8f5c29, float:-1.12)
            r12.reflectiveCurveToRelative(r0, r4, r2, r4)
            r12.close()
            java.util.List r2 = r12.getNodes()
            r16 = 14336(0x3800, float:2.0089E-41)
            r17 = 0
            java.lang.String r4 = ""
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5273addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.filled.LocationOnKt._locationOn = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.filled.LocationOnKt.getLocationOn(androidx.compose.material.icons.Icons$Filled):androidx.compose.ui.graphics.vector.ImageVector");
    }
}

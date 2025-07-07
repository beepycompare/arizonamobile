package androidx.compose.ui.text;

import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
/* compiled from: Bullet.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, d2 = {"DefaultBullet", "Landroidx/compose/ui/text/Bullet;", "getDefaultBullet", "()Landroidx/compose/ui/text/Bullet;", "DefaultBulletIndentation", "Landroidx/compose/ui/unit/TextUnit;", "getDefaultBulletIndentation", "()J", "J", "DefaultBulletPadding", "DefaultBulletSize", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BulletKt {
    private static final Bullet DefaultBullet;
    private static final long DefaultBulletIndentation = TextUnitKt.getEm(1);
    private static final long DefaultBulletPadding;
    private static final long DefaultBulletSize;

    static {
        long em = TextUnitKt.getEm(0.25d);
        DefaultBulletSize = em;
        long em2 = TextUnitKt.getEm(0.25d);
        DefaultBulletPadding = em2;
        DefaultBullet = new Bullet(CircleShape.INSTANCE, em, em2, null, 1.0f, Fill.INSTANCE, null);
    }

    public static final long getDefaultBulletIndentation() {
        return DefaultBulletIndentation;
    }

    public static final Bullet getDefaultBullet() {
        return DefaultBullet;
    }
}

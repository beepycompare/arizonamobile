package com.arizona.game.core;
/* loaded from: classes3.dex */
final class TouchpadClickStabilizer {
    static final float RADIUS = 48.0f;
    static final float TOP_ZONE = 0.35f;
    private final Anchor[] anchors = {new Anchor(), new Anchor()};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Anchor {
        boolean active;
        int id;
        boolean stabilized;
        float x;
        float y;

        private Anchor() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void begin(TouchpadJitterFilter[] touchpadJitterFilterArr, float f) {
        clear();
        for (TouchpadJitterFilter touchpadJitterFilter : touchpadJitterFilterArr) {
            if (touchpadJitterFilter.active) {
                add(touchpadJitterFilter.id, touchpadJitterFilter.x, touchpadJitterFilter.y, f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apply(int i, float f, float f2, float f3, float[] fArr) {
        Anchor find = find(i);
        if (find == null) {
            find = add(i, f, f2, f3);
        }
        if (!find.stabilized) {
            fArr[0] = f;
            fArr[1] = f2;
            return;
        }
        float f4 = f - find.x;
        float f5 = f2 - find.y;
        float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        if (sqrt <= RADIUS) {
            fArr[0] = find.x;
            fArr[1] = find.y;
            return;
        }
        float f6 = (sqrt - RADIUS) / sqrt;
        fArr[0] = find.x + (f4 * f6);
        fArr[1] = find.y + (f5 * f6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void retain(TouchpadJitterFilter[] touchpadJitterFilterArr) {
        Anchor[] anchorArr;
        for (Anchor anchor : this.anchors) {
            if (anchor.active) {
                boolean z = false;
                for (TouchpadJitterFilter touchpadJitterFilter : touchpadJitterFilterArr) {
                    z |= touchpadJitterFilter.active && touchpadJitterFilter.id == anchor.id;
                }
                if (!z) {
                    anchor.active = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        for (Anchor anchor : this.anchors) {
            anchor.active = false;
        }
    }

    private Anchor add(int i, float f, float f2, float f3) {
        boolean z = this.anchors[0].active;
        Anchor[] anchorArr = this.anchors;
        Anchor anchor = !z ? anchorArr[0] : anchorArr[1];
        anchor.active = true;
        anchor.id = i;
        anchor.x = f;
        anchor.y = f2;
        anchor.stabilized = f2 <= f3 * 0.35f;
        return anchor;
    }

    private Anchor find(int i) {
        Anchor[] anchorArr;
        for (Anchor anchor : this.anchors) {
            if (anchor.active && anchor.id == i) {
                return anchor;
            }
        }
        return null;
    }
}

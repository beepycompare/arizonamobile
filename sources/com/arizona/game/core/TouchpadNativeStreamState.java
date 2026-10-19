package com.arizona.game.core;
/* loaded from: classes3.dex */
final class TouchpadNativeStreamState {
    private int activePointers;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void forwarded(int i, int i2) {
        if (i == 3) {
            this.activePointers = 0;
        } else if (i2 < 0 || i2 >= 32) {
        } else {
            int i3 = 1 << i2;
            if (i == 0 || i == 5) {
                this.activePointers |= i3;
            } else if (i == 1 || i == 6) {
                this.activePointers &= ~i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isActive() {
        return this.activePointers != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean takeCancel() {
        boolean z;
        z = this.activePointers != 0;
        this.activePointers = 0;
        return z;
    }
}

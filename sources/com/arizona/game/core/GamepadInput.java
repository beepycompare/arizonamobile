package com.arizona.game.core;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.InputDeviceCompat;
import com.arizona.game.natives;
import com.google.android.gms.location.LocationRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class GamepadInput implements InputManager.InputDeviceListener {
    private static final int CIRCLE = 2;
    private static final int CROSS = 1;
    private static final int DOWN = 2048;
    private static final int L1 = 16;
    private static final int L2 = 64;
    private static final int L3 = 256;
    private static final int LEFT = 4096;
    private static final int R1 = 32;
    private static final int R2 = 128;
    private static final int R3 = 512;
    private static final int RIGHT = 8192;
    private static final int SELECT = 16384;
    private static final int SQUARE = 4;
    private static final int START = 32768;
    private static final float STICK_DEADZONE = 0.2f;
    private static final int TRIANGLE = 8;
    private static final float TRIGGER_DEADZONE = 0.02f;
    private static final int UP = 1024;
    private int buttons;
    private int deviceId = -1;
    private int hat;
    private float leftTrigger;
    private boolean leftTriggerUsesAxis;
    private float leftX;
    private float leftY;
    private float rightTrigger;
    private boolean rightTriggerUsesAxis;
    private float rightX;
    private float rightY;

    private static int buttonForKey(int i) {
        if (i != 96) {
            if (i != 97) {
                if (i != 99) {
                    if (i != 100) {
                        switch (i) {
                            case 19:
                                return 1024;
                            case 20:
                                return 2048;
                            case 21:
                                return 4096;
                            case 22:
                                return 8192;
                            default:
                                switch (i) {
                                    case 102:
                                        return 16;
                                    case 103:
                                        return 32;
                                    case 104:
                                        return 64;
                                    case LocationRequest.PRIORITY_NO_POWER /* 105 */:
                                        return 128;
                                    case 106:
                                        return 256;
                                    case 107:
                                        return 512;
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                        return 32768;
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                        return 16384;
                                    default:
                                        return 0;
                                }
                        }
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register(Context context) {
        InputManager inputManager = (InputManager) context.getSystemService("input");
        if (inputManager != null) {
            inputManager.registerInputDeviceListener(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregister(Context context) {
        InputManager inputManager = (InputManager) context.getSystemService("input");
        if (inputManager != null) {
            inputManager.unregisterInputDeviceListener(this);
        }
    }

    static boolean isController(InputEvent inputEvent) {
        InputDevice device = inputEvent.getDevice();
        int sources = device != null ? device.getSources() : inputEvent.getSource();
        return (sources & 1025) == 1025 || (sources & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isControllerKey(KeyEvent keyEvent) {
        return isController(keyEvent) && buttonForKey(keyEvent.getKeyCode()) != 0;
    }

    private boolean accept(InputEvent inputEvent) {
        if (isController(inputEvent) && !AdaptiveTriggers.ownsInput()) {
            if (this.deviceId == -1) {
                this.deviceId = inputEvent.getDeviceId();
            }
            return this.deviceId == inputEvent.getDeviceId();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onKeyEvent(KeyEvent keyEvent) {
        if (isController(keyEvent)) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                AdaptiveTriggers.onGamepadActivity(keyEvent.getDeviceId());
            }
            int buttonForKey = buttonForKey(keyEvent.getKeyCode());
            if (buttonForKey == 0) {
                return false;
            }
            if (accept(keyEvent)) {
                if (keyEvent.getAction() == 0) {
                    if (keyEvent.getRepeatCount() == 0) {
                        this.buttons |= buttonForKey;
                        send();
                    }
                } else if (keyEvent.getAction() == 1) {
                    this.buttons &= ~buttonForKey;
                    if (buttonForKey == 64 && this.leftTrigger == 0.0f) {
                        this.leftTriggerUsesAxis = false;
                    }
                    if (buttonForKey == 128 && this.rightTrigger == 0.0f) {
                        this.rightTriggerUsesAxis = false;
                    }
                    send();
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onMotionEvent(MotionEvent motionEvent) {
        InputDevice device;
        observeTouchpadEvent(motionEvent);
        if (motionEvent.getActionMasked() == 2 && (motionEvent.getSource() & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232) {
            if (accept(motionEvent) && (device = motionEvent.getDevice()) != null) {
                this.leftX = stick(motionEvent, device, 0);
                this.leftY = stick(motionEvent, device, 1);
                this.rightX = stick(motionEvent, device, axis(device, 11, 12));
                this.rightY = stick(motionEvent, device, axis(device, 14, 13));
                this.leftTrigger = trigger(motionEvent, device, 17, 23);
                float trigger = trigger(motionEvent, device, 18, 22);
                this.rightTrigger = trigger;
                this.leftTriggerUsesAxis = this.leftTrigger > 0.0f || (this.leftTriggerUsesAxis && (this.buttons & 64) != 0);
                this.rightTriggerUsesAxis = trigger > 0.0f || (this.rightTriggerUsesAxis && (this.buttons & 128) != 0);
                this.hat = 0;
                float axisValue = motionEvent.getAxisValue(15);
                float axisValue2 = motionEvent.getAxisValue(16);
                if (axisValue < -0.5f) {
                    this.hat |= 4096;
                }
                if (axisValue > 0.5f) {
                    this.hat |= 8192;
                }
                if (axisValue2 < -0.5f) {
                    this.hat |= 1024;
                }
                if (axisValue2 > 0.5f) {
                    this.hat |= 2048;
                }
                send();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void observeTouchpadEvent(MotionEvent motionEvent) {
        InputDevice device = motionEvent.getDevice();
        if (device == null || !AdaptiveTriggerProtocol.supported(device.getVendorId(), device.getProductId()) || (motionEvent.getSource() & 2) == 0) {
            return;
        }
        AdaptiveTriggers.onGamepadActivity(motionEvent.getDeviceId());
    }

    private static int axis(InputDevice inputDevice, int i, int i2) {
        return inputDevice.getMotionRange(i, InputDeviceCompat.SOURCE_JOYSTICK) != null ? i : i2;
    }

    private static float stick(MotionEvent motionEvent, InputDevice inputDevice, int i) {
        InputDevice.MotionRange motionRange = inputDevice.getMotionRange(i, InputDeviceCompat.SOURCE_JOYSTICK);
        if (motionRange == null || motionRange.getMax() <= motionRange.getMin()) {
            return 0.0f;
        }
        float max = (motionRange.getMax() - motionRange.getMin()) / 2.0f;
        float axisValue = (motionEvent.getAxisValue(i) - ((motionRange.getMin() + motionRange.getMax()) / 2.0f)) / max;
        if (Math.abs(axisValue) <= Math.max(0.2f, motionRange.getFlat() / max)) {
            return 0.0f;
        }
        return Math.max(-1.0f, Math.min(1.0f, axisValue));
    }

    private static float trigger(MotionEvent motionEvent, InputDevice inputDevice, int i, int i2) {
        return Math.max(triggerAxis(motionEvent, inputDevice, i), triggerAxis(motionEvent, inputDevice, i2));
    }

    private static float triggerAxis(MotionEvent motionEvent, InputDevice inputDevice, int i) {
        InputDevice.MotionRange motionRange = inputDevice.getMotionRange(i, InputDeviceCompat.SOURCE_JOYSTICK);
        if (motionRange == null || motionRange.getMax() <= motionRange.getMin()) {
            return 0.0f;
        }
        float axisValue = (motionEvent.getAxisValue(i) - motionRange.getMin()) / (motionRange.getMax() - motionRange.getMin());
        if (axisValue <= Math.max((float) TRIGGER_DEADZONE, motionRange.getFlat() / (motionRange.getMax() - motionRange.getMin()))) {
            return 0.0f;
        }
        return Math.max(0.0f, Math.min(1.0f, axisValue));
    }

    private void send() {
        send(false);
    }

    private void send(boolean z) {
        boolean z2;
        int i = this.buttons;
        if (this.leftTriggerUsesAxis) {
            i &= -65;
        }
        if (this.rightTriggerUsesAxis) {
            i &= -129;
        }
        synchronized (AdaptiveTriggers.class) {
            if (AdaptiveTriggers.ownsInput()) {
                z2 = z;
            } else {
                z2 = z;
                natives.GamepadState(i | this.hat, this.leftX, this.leftY, this.rightX, this.rightY, this.leftTrigger, this.rightTrigger, z2);
            }
        }
        if (z2) {
            return;
        }
        if (this.buttons == 0 && this.hat == 0 && this.leftTrigger <= 0.0f && this.rightTrigger <= 0.0f && this.leftX == 0.0f && this.leftY == 0.0f && this.rightX == 0.0f && this.rightY == 0.0f) {
            return;
        }
        AdaptiveTriggers.onGamepadActivity(this.deviceId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.deviceId == -1) {
            return;
        }
        this.deviceId = -1;
        this.hat = 0;
        this.buttons = 0;
        this.rightTrigger = 0.0f;
        this.leftTrigger = 0.0f;
        this.rightY = 0.0f;
        this.rightX = 0.0f;
        this.leftY = 0.0f;
        this.leftX = 0.0f;
        this.rightTriggerUsesAxis = false;
        this.leftTriggerUsesAxis = false;
        send(true);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int i) {
        if (this.deviceId != i) {
            return;
        }
        InputDevice device = InputDevice.getDevice(i);
        if (device == null || !((device.getSources() & 1025) == 1025 || (device.getSources() & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232)) {
            reset();
        }
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int i) {
        if (this.deviceId == i) {
            reset();
        }
    }
}

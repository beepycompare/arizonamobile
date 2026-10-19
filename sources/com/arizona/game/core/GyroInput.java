package com.arizona.game.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.InputDevice;
import com.arizona.game.natives;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class GyroInput implements SensorEventListener {
    private static final long POLL_INTERVAL_MS = 500;
    private boolean gamepadHavePrevious;
    private long gamepadLastGyroNs;
    private SensorManager gamepadManager;
    private float gamepadPreviousPitch;
    private float gamepadPreviousYaw;
    private boolean gamepadRegistered;
    private boolean gamepadRotationVector;
    private Sensor gamepadSensor;
    private boolean phoneHavePrevious;
    private float phonePreviousPitch;
    private float phonePreviousYaw;
    private boolean phoneRegistered;
    private final Sensor phoneSensor;
    private final SensorManager sensorManager;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final float[] rotationMatrix = new float[9];
    private final Runnable poll = new Runnable() { // from class: com.arizona.game.core.GyroInput.1
        @Override // java.lang.Runnable
        public void run() {
            boolean IsGyroInputNeeded = natives.IsGyroInputNeeded();
            GyroInput.this.findGamepadSensor();
            boolean z = true;
            natives.SetGamepadGyroAvailable(GyroInput.this.gamepadSensor != null);
            GyroInput.this.setPhoneRegistered(IsGyroInputNeeded);
            GyroInput gyroInput = GyroInput.this;
            if (!IsGyroInputNeeded || gyroInput.gamepadSensor == null) {
                z = false;
            }
            gyroInput.setGamepadRegistered(z);
            GyroInput.this.handler.postDelayed(this, 500L);
        }
    };

    private static float wrap(float f) {
        double d = f;
        return d > 3.141592653589793d ? f - 6.2831855f : d < -3.141592653589793d ? f + 6.2831855f : f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GyroInput(Context context) {
        Sensor sensor;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(15);
            if (sensor == null) {
                sensor = sensorManager.getDefaultSensor(11);
            }
        } else {
            sensor = null;
        }
        this.phoneSensor = sensor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register() {
        this.handler.removeCallbacks(this.poll);
        this.handler.post(this.poll);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregister() {
        this.handler.removeCallbacks(this.poll);
        setPhoneRegistered(false);
        setGamepadRegistered(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneRegistered(boolean z) {
        if (this.phoneRegistered == z) {
            return;
        }
        this.phoneRegistered = z;
        this.phoneHavePrevious = false;
        Sensor sensor = this.phoneSensor;
        if (sensor == null) {
            return;
        }
        SensorManager sensorManager = this.sensorManager;
        if (z) {
            sensorManager.registerListener(this, sensor, 1);
        } else {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGamepadRegistered(boolean z) {
        SensorManager sensorManager;
        if (this.gamepadRegistered == z) {
            return;
        }
        this.gamepadRegistered = z;
        this.gamepadHavePrevious = false;
        this.gamepadLastGyroNs = 0L;
        Sensor sensor = this.gamepadSensor;
        if (sensor == null || (sensorManager = this.gamepadManager) == null) {
            return;
        }
        if (z) {
            sensorManager.registerListener(this, sensor, 1);
        } else {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findGamepadSensor() {
        Sensor sensor;
        SensorManager sensorManager;
        boolean z;
        SensorManager sensorManager2;
        Sensor defaultSensor;
        boolean z2 = true;
        Sensor sensor2 = null;
        if (Build.VERSION.SDK_INT >= 31) {
            sensor = null;
            sensorManager = null;
            for (int i : InputDevice.getDeviceIds()) {
                InputDevice device = InputDevice.getDevice(i);
                if (device != null && (device.getSources() & 16778257) != 0 && (sensorManager2 = device.getSensorManager()) != null) {
                    if (sensor == null && (defaultSensor = sensorManager2.getDefaultSensor(4)) != null) {
                        sensorManager = sensorManager2;
                        sensor = defaultSensor;
                    }
                    Sensor pickRotationVector = pickRotationVector(sensorManager2);
                    if (pickRotationVector != null) {
                        z = true;
                        sensorManager = sensorManager2;
                        sensor = pickRotationVector;
                        break;
                    }
                }
            }
        } else {
            sensor = null;
            sensorManager = null;
        }
        z = false;
        if (sensor == null) {
            for (Sensor sensor3 : this.sensorManager.getDynamicSensorList(-1)) {
                int type = sensor3.getType();
                if (type == 15 || type == 11) {
                    sensorManager = this.sensorManager;
                    sensor = sensor3;
                    break;
                } else if (type == 4) {
                    sensor2 = sensor3;
                }
            }
            z2 = z;
            if (sensor != null || sensor2 == null) {
                z = z2;
            } else {
                sensorManager = this.sensorManager;
                z = z2;
                sensor = sensor2;
            }
        }
        if (sensor == this.gamepadSensor && sensorManager == this.gamepadManager && z == this.gamepadRotationVector) {
            return;
        }
        setGamepadRegistered(false);
        this.gamepadSensor = sensor;
        this.gamepadManager = sensorManager;
        this.gamepadRotationVector = z;
    }

    private static Sensor pickRotationVector(SensorManager sensorManager) {
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        return defaultSensor != null ? defaultSensor : sensorManager.getDefaultSensor(11);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == this.gamepadSensor) {
            if (this.gamepadRotationVector) {
                onRotationVector(sensorEvent, true);
                return;
            } else {
                onGyroscope(sensorEvent);
                return;
            }
        }
        onRotationVector(sensorEvent, false);
    }

    private void onRotationVector(SensorEvent sensorEvent, boolean z) {
        SensorManager.getRotationMatrixFromVector(this.rotationMatrix, sensorEvent.values);
        float[] fArr = this.rotationMatrix;
        float atan2 = (float) Math.atan2(-fArr[2], -fArr[5]);
        float asin = (float) Math.asin(Math.max(-1.0f, Math.min(1.0f, -fArr[8])));
        if (z) {
            if (this.gamepadHavePrevious) {
                float wrap = wrap(atan2 - this.gamepadPreviousYaw);
                float f = asin - this.gamepadPreviousPitch;
                if (wrap != 0.0f || f != 0.0f) {
                    natives.GamepadGyroState(wrap, f);
                }
            }
            this.gamepadHavePrevious = true;
            this.gamepadPreviousYaw = atan2;
            this.gamepadPreviousPitch = asin;
            return;
        }
        if (this.phoneHavePrevious) {
            float wrap2 = wrap(atan2 - this.phonePreviousYaw);
            float f2 = asin - this.phonePreviousPitch;
            if (wrap2 != 0.0f || f2 != 0.0f) {
                natives.GyroState(wrap2, f2);
            }
        }
        this.phoneHavePrevious = true;
        this.phonePreviousYaw = atan2;
        this.phonePreviousPitch = asin;
    }

    private void onGyroscope(SensorEvent sensorEvent) {
        if (this.gamepadLastGyroNs != 0) {
            float f = ((float) (sensorEvent.timestamp - this.gamepadLastGyroNs)) * 1.0E-9f;
            if (f > 0.0f && f < 0.5f) {
                natives.GamepadGyroState((-sensorEvent.values[2]) * f, sensorEvent.values[0] * f);
            }
        }
        this.gamepadLastGyroNs = sensorEvent.timestamp;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        this.phoneHavePrevious = false;
        this.gamepadHavePrevious = false;
        this.gamepadLastGyroNs = 0L;
    }
}

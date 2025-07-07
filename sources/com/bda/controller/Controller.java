package com.bda.controller;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.bda.controller.IControllerListener;
import com.bda.controller.IControllerMonitor;
import com.bda.controller.IControllerService;
/* loaded from: classes3.dex */
public final class Controller {
    public static final int ACTION_CONNECTED = 1;
    public static final int ACTION_CONNECTING = 2;
    public static final int ACTION_DISCONNECTED = 0;
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_FALSE = 0;
    public static final int ACTION_TRUE = 1;
    public static final int ACTION_UP = 1;
    public static final int ACTION_VERSION_MOGA = 0;
    public static final int ACTION_VERSION_MOGAPRO = 1;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    static final int CONTROLLER_ID = 1;
    public static final int INFO_ACTIVE_DEVICE_COUNT = 2;
    public static final int INFO_KNOWN_DEVICE_COUNT = 1;
    public static final int INFO_UNKNOWN = 0;
    public static final int KEYCODE_BUTTON_A = 96;
    public static final int KEYCODE_BUTTON_B = 97;
    public static final int KEYCODE_BUTTON_L1 = 102;
    public static final int KEYCODE_BUTTON_L2 = 104;
    public static final int KEYCODE_BUTTON_R1 = 103;
    public static final int KEYCODE_BUTTON_R2 = 105;
    public static final int KEYCODE_BUTTON_SELECT = 109;
    public static final int KEYCODE_BUTTON_START = 108;
    public static final int KEYCODE_BUTTON_THUMBL = 106;
    public static final int KEYCODE_BUTTON_THUMBR = 107;
    public static final int KEYCODE_BUTTON_X = 99;
    public static final int KEYCODE_BUTTON_Y = 100;
    public static final int KEYCODE_DPAD_DOWN = 20;
    public static final int KEYCODE_DPAD_LEFT = 21;
    public static final int KEYCODE_DPAD_RIGHT = 22;
    public static final int KEYCODE_DPAD_UP = 19;
    public static final int KEYCODE_UNKNOWN = 0;
    static final int LEGACY_KEYCODE_BUTTON_X = 98;
    static final int LEGACY_KEYCODE_BUTTON_Y = 99;
    public static final int STATE_CONNECTION = 1;
    public static final int STATE_CURRENT_PRODUCT_VERSION = 4;
    public static final int STATE_POWER_LOW = 2;
    @Deprecated
    public static final int STATE_SELECTED_VERSION = 4;
    public static final int STATE_SUPPORTED_PRODUCT_VERSION = 3;
    @Deprecated
    public static final int STATE_SUPPORTED_VERSION = 3;
    public static final int STATE_UNKNOWN = 0;
    final Context mContext;
    boolean mIsBound = false;
    IControllerService mService = null;
    final IControllerListener.Stub mListenerStub = new IControllerListenerStub();
    final IControllerMonitor.Stub mMonitorStub = new IControllerMonitorStub();
    final ServiceConnection mServiceConnection = new ServiceConnection();
    int mActivityEvent = 6;
    Handler mHandler = null;
    ControllerListener mListener = null;
    ControllerMonitor mMonitor = null;

    /* loaded from: classes3.dex */
    class IControllerListenerStub extends IControllerListener.Stub {
        IControllerListenerStub() {
        }

        @Override // com.bda.controller.IControllerListener
        public void onKeyEvent(KeyEvent keyEvent) throws RemoteException {
            if (keyEvent.getControllerId() != 1 || Controller.this.mListener == null) {
                return;
            }
            KeyRunnable keyRunnable = new KeyRunnable(keyEvent);
            if (Controller.this.mHandler != null) {
                Controller.this.mHandler.post(keyRunnable);
            } else {
                keyRunnable.run();
            }
        }

        @Override // com.bda.controller.IControllerListener
        public void onMotionEvent(MotionEvent motionEvent) throws RemoteException {
            if (motionEvent.getControllerId() != 1 || Controller.this.mListener == null) {
                return;
            }
            MotionRunnable motionRunnable = new MotionRunnable(motionEvent);
            if (Controller.this.mHandler != null) {
                Controller.this.mHandler.post(motionRunnable);
            } else {
                motionRunnable.run();
            }
        }

        @Override // com.bda.controller.IControllerListener
        public void onStateEvent(StateEvent stateEvent) throws RemoteException {
            if (stateEvent.getControllerId() != 1 || Controller.this.mListener == null) {
                return;
            }
            StateRunnable stateRunnable = new StateRunnable(stateEvent);
            if (Controller.this.mHandler != null) {
                Controller.this.mHandler.post(stateRunnable);
            } else {
                stateRunnable.run();
            }
        }
    }

    /* loaded from: classes3.dex */
    class IControllerMonitorStub extends IControllerMonitor.Stub {
        IControllerMonitorStub() {
        }

        @Override // com.bda.controller.IControllerMonitor
        public void onLog(int i, int i2, String str) throws RemoteException {
            if (Controller.this.mMonitor != null) {
                Controller.this.mMonitor.onLog(i, i2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    class KeyRunnable implements Runnable {
        final KeyEvent mEvent;

        public KeyRunnable(KeyEvent keyEvent) {
            this.mEvent = keyEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Controller.this.mListener != null) {
                Controller.this.mListener.onKeyEvent(this.mEvent);
            }
        }
    }

    /* loaded from: classes3.dex */
    class MotionRunnable implements Runnable {
        final MotionEvent mEvent;

        public MotionRunnable(MotionEvent motionEvent) {
            this.mEvent = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Controller.this.mListener != null) {
                Controller.this.mListener.onMotionEvent(this.mEvent);
            }
        }
    }

    /* loaded from: classes3.dex */
    class ServiceConnection implements android.content.ServiceConnection {
        ServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Controller.this.mService = IControllerService.Stub.asInterface(iBinder);
            Controller.this.registerListener();
            Controller.this.registerMonitor();
            if (Controller.this.mActivityEvent == 5) {
                Controller.this.sendMessage(1, 5);
                Controller.this.sendMessage(1, 7);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Controller.this.mService = null;
        }
    }

    /* loaded from: classes3.dex */
    class StateRunnable implements Runnable {
        final StateEvent mEvent;

        public StateRunnable(StateEvent stateEvent) {
            this.mEvent = stateEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Controller.this.mListener != null) {
                Controller.this.mListener.onStateEvent(this.mEvent);
            }
        }
    }

    Controller(Context context) {
        this.mContext = context;
    }

    public static final Controller getInstance(Context context) {
        return new Controller(context);
    }

    public void allowNewConnections() {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.allowNewConnections();
            } catch (RemoteException unused) {
            }
        }
    }

    public void disallowNewConnections() {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.disallowNewConnections();
            } catch (RemoteException unused) {
            }
        }
    }

    public final void exit() {
        setListener(null, null);
        setMonitor(null);
        if (this.mIsBound) {
            this.mContext.unbindService(this.mServiceConnection);
            this.mIsBound = false;
        }
    }

    public final float getAxisValue(int i) {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                return iControllerService.getAxisValue(1, i);
            } catch (RemoteException unused) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final int getInfo(int i) {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                return iControllerService.getInfo(i);
            } catch (RemoteException unused) {
                return 0;
            }
        }
        return 0;
    }

    public final int getKeyCode(int i) {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                return iControllerService.getKeyCode2(1, i);
            } catch (RemoteException unused) {
                if (i == 99) {
                    i = LEGACY_KEYCODE_BUTTON_X;
                } else if (i == 100) {
                    i = 99;
                }
                try {
                    return this.mService.getKeyCode(1, i);
                } catch (RemoteException unused2) {
                }
            }
        }
        return 1;
    }

    public final int getState(int i) {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                return iControllerService.getState(1, i);
            } catch (RemoteException unused) {
                return 0;
            }
        }
        return 0;
    }

    public final boolean init() {
        if (!this.mIsBound) {
            Intent intent = new Intent(IControllerService.class.getName());
            this.mContext.startService(intent);
            this.mContext.bindService(intent, this.mServiceConnection, 1);
            this.mIsBound = true;
        }
        return this.mIsBound;
    }

    public void isAllowingNewConnections() {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.isAllowingNewConnections();
            } catch (RemoteException unused) {
            }
        }
    }

    public final void onPause() {
        this.mActivityEvent = 6;
        sendMessage(1, 6);
        registerListener();
    }

    public final void onResume() {
        this.mActivityEvent = 5;
        sendMessage(1, 5);
        registerListener();
    }

    void registerListener() {
        IControllerService iControllerService;
        if (this.mListener == null || (iControllerService = this.mService) == null) {
            return;
        }
        try {
            try {
                iControllerService.registerListener2(this.mListenerStub, this.mActivityEvent);
            } catch (RemoteException unused) {
                this.mService.registerListener(this.mListenerStub, this.mActivityEvent);
            }
        } catch (RemoteException unused2) {
        }
    }

    void registerMonitor() {
        IControllerService iControllerService;
        if (this.mMonitor == null || (iControllerService = this.mService) == null) {
            return;
        }
        try {
            iControllerService.registerMonitor(this.mMonitorStub, this.mActivityEvent);
        } catch (RemoteException unused) {
        }
    }

    void sendMessage(int i, int i2) {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.sendMessage(i, i2);
            } catch (RemoteException unused) {
            }
        }
    }

    public final void setListener(ControllerListener controllerListener, Handler handler) {
        unregisterListener();
        this.mListener = controllerListener;
        this.mHandler = handler;
        registerListener();
    }

    public final void setMonitor(ControllerMonitor controllerMonitor) {
        unregisterMonitor();
        this.mMonitor = controllerMonitor;
        registerMonitor();
    }

    void unregisterListener() {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.unregisterListener(this.mListenerStub, this.mActivityEvent);
            } catch (RemoteException unused) {
            }
        }
    }

    void unregisterMonitor() {
        IControllerService iControllerService = this.mService;
        if (iControllerService != null) {
            try {
                iControllerService.unregisterMonitor(this.mMonitorStub, this.mActivityEvent);
            } catch (RemoteException unused) {
            }
        }
    }
}

package com.example.tugas2pesawat;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
/**
* A view container where OpenGL ES graphics can be drawn on screen.
* This view can also be used to capture touch events, such as a user
* interacting with drawn objects.
*/
public class ESSurfaceView extends GLSurfaceView {
	private final ESRender esRender;
	public ESSurfaceView(Context context) {
	super(context);
	// Set the Renderer for drawing on the GLSur-faceView
	esRender = new ESRender();
	setRenderer(esRender);
	// To enable keypad
	this.setFocusable(true);
	this.requestFocus();
	// To enable touch mode
	this.setFocusableInTouchMode(true);
	// Render the view only when there is a change in the drawing data
	// merender hanya ketika ada perubahan/ event
	//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	//private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	//private float mPreviousX;
	//private float mPreviousY;
	@Override
	public boolean onTouchEvent(MotionEvent v) {
	// MotionEvent reports input details from the touch screen
	// and other input controls. In this case, we are only
	// interested in events where the touch position changed.
	/*float x = e.getX();
	float y = e.getY();*/
	switch (v.getAction()) {
	case MotionEvent.ACTION_DOWN:
	Log.v("Test Action Down", "action down working");
	Log.i("Test Action Nilai", ""+Math.abs(esRender.getRunMode()-1));
	esRender.setRunMode(Math.abs(esRender.getRunMode()-1));
	//break;
	requestRender();
	//case MotionEvent.ACTION_POINTER_UP:
	//Log.v("Test Action ACTION_POINTER_UP", "action working");
	//Log.i("Test Action Nilai", ""+Math.abs(esRender.getAnimateStep()));
	//esRender.setAnimateStep(esRender.getAnimateStep()+8.0f);
	//requestRender();
	//case MotionEvent.ACTION_MOVE:
	//Log.v("Test Action ACTION_POINTER_DOWN", "action working");
	//Log.i("Test Action Nilai", ""+Math.abs(esRender.getAnimateStep()));
	//esRender.setAnimateStep(esRender.getAnimateStep()-8.0f);
	//requestRender();
	//case MotionEvent.ACTION_UP:
	//Log.v("Test Action Up", "action up working");
	//esRender.setRunMode(esRender.getRunMode());
	//requestRender();
	//case MotionEvent.ACTION_MOVE:
	//esRender.setRunMode(esRender.getRunMode());
	//requestRender();
	}
	//mPreviousX = x;
	// mPreviousY = y;
	return true;
	//break;
	}
	// Key-up event handler
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
	switch (keyCode) {
	case KeyEvent.KEYCODE_DPAD_RIGHT: // In-crease rightward speed
	Log.v("Test Action KEYCODE_DPAD_RIGHT", "action working");
	Log.i("Test Action Nilai", ""+Math.abs(esRender.getAnimateStep()));
	esRender.setAnimateStep(esRender.getAnimateStep()+8.0f);
	requestRender();
	//ballSpeedX++;
	break;
	case KeyEvent.KEYCODE_DPAD_LEFT: // In-crease leftward speed
		esRender.setAnimateStep(esRender.getAnimateStep()-8.0f);
		requestRender();
		//ballSpeedX--;
		break;
		case KeyEvent.KEYCODE_DPAD_UP: // In-crease upward speed
		//ballSpeedY--;
		break;
		case KeyEvent.KEYCODE_DPAD_DOWN: // In-crease downward speed
			//ballSpeedY++;
			break;
			case KeyEvent.KEYCODE_DPAD_CENTER: // Stop
			//ballSpeedX = 0;
			//ballSpeedY = 0;
			break;
			case KeyEvent.KEYCODE_A: // Zoom in
			Log.v("Test Action KEYCODE_DPAD_RIGHT", "action working");
			Log.i("Test Action Nilai", ""+Math.abs(esRender.getAnimateStep()));
			esRender.setAnimateStep(esRender.getAnimateStep()+8.0f);
			requestRender();
			// Max radius is about 90% of half of the smaller dimension
			//float maxRadius = (xMax > yMax) ? yMax / 2 * 0.9f : xMax / 2 * 0.9f;
			//if (ballRadius < maxRadius) {
			//ballRadius *= 1.05; // Increase radius by 5%
			//}
			break;
			case KeyEvent.KEYCODE_Z: // Zoom out
			Log.v("Test Action KEYCODE_DPAD_RIGHT", "action working");
			Log.i("Test Action Nilai", ""+Math.abs(esRender.getAnimateStep()));
			esRender.setAnimateStep(esRender.getAnimateStep()-8.0f);
			requestRender();
			//if (ballRadius > 20) { // Mini-mum radius
			// ballRadius *= 0.95; // De-crease radius by 5%
			//}
			break;
			}
			return true; // Event handled
			}
			}
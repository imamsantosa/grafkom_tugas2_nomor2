package com.example.tugas2pesawat;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
//import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class ESRender implements Renderer {
//	private TransObject transobject; // the primitive object to be drawn
//	private TransPolarObject transpolarobject;
//	private TransKubusObject kubus;
	private TexturePesawat pesawat;
	int RunMode = 1;
	float CurrentAngle = 0.0f; // Angle in degrees
	float AnimateStep = 1.0f; // Rotation step per update

	/** Constructor to set the handed over context */
	public ESRender() {
		this.pesawat = new TexturePesawat();
	
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// clear Screen and Depth Buffer
		// gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // set background dgn warna
		// putih
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Reset the Modelview Matrix
		gl.glLoadIdentity();
		// menampilkan piramida
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, 0.0f, 0.0f);
		// Rotate the object
		gl.glTranslatef(0.0f, 0.0f, -5.0f);
		gl.glScalef(0.5f, 0.5f, 0.5f); // Scale down
		//GLU.gluLookAt(gl, 0.f, 0.f, 1f, 2f, 3f, 0.f, 0.5f, 0f, -2f);
		//GLU.gluLookAt(gl, 0.f, 0.f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, -2.f);
		//GLU.gluLookAt(gl, 0.f, 0.f, 0.2f, 0.1f, 0.0f, 2.0f, 1.0f, 1.0f, -50.f);
		//GLU.gluLookAt(gl, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
		GLU.gluLookAt(gl, 0.0f, 0.f, 2f, 0.0f, 0.0f, 0.f, 0.0f, 2f, 0.0f);
		gl.glRotatef(CurrentAngle, 0.1f, 1.0f, -0.1f);
		pesawat.draw_sayapPesawat(gl);
		pesawat.draw_badanPesawat(gl);
		gl.glPopMatrix();
		// Update the rotational angle after each refresh
		if (RunMode == 1) {
			// re-Calculate animation parame-ters
			CurrentAngle += AnimateStep;
			if (CurrentAngle > 360.0) {
				// CurrentAngle -= 360.0*Math.floor(CurrentAngle/360.0);
				CurrentAngle = 0.0f;
				CurrentAngle += AnimateStep;
			}
		}
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		if (height == 0)
			height = 1; // To prevent divide by zero
		
		float aspect = (float) width / height;
		// Set the viewport (display area) to cover the entire window
		gl.glViewport(0, 0, width, height);
		// Setup perspective projection, with as-pect ratio matches viewport
		gl.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
		gl.glLoadIdentity(); // Reset projection matrix
		// Use perspective projection
		GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);
		// gl.glOrthof(-3.0f, 3.0f, -3.0f, 3.0f, -3.0f, 3.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW); // Select model-view matrix
		gl.glLoadIdentity(); // Reset
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set color's clear-value to
													// black
		gl.glClearDepthf(1.0f); // Set depth's clear-value to farthest
		gl.glEnable(GL10.GL_DEPTH_TEST); // Ena-bles depth-buffer for hidden
		// surface removal
		gl.glDepthFunc(GL10.GL_LEQUAL); // The type of depth testing to do
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); // nice
		// perspective
		// view
		gl.glShadeModel(GL10.GL_SMOOTH); // Ena-ble smooth shading of color
		gl.glDisable(GL10.GL_DITHER); // Disable dithering for better
		// performance
	}

	public int getRunMode() {
		return RunMode;
	}

	public void setRunMode(int mRunMode) {
		RunMode = mRunMode;
	}

	public float getAnimateStep() {
		return AnimateStep;
	}

	public void setAnimateStep(float mAnimateStep) {
		AnimateStep = mAnimateStep;
	}
}
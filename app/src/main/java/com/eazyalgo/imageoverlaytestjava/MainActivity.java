package com.eazyalgo.imageoverlaytestjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.ar.sceneform.Sceneform;
import com.google.ar.sceneform.rendering.RenderableInstance;
import com.google.ar.sceneform.ux.ArFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addFragmentOnAttachListener((fragmentManager, fragment) -> {
            if (fragment.getId() == R.id.arFragment) {
                ArFragment arFragment = (ArFragment) fragment;
                // Load model.glb from assets folder or http url
                arFragment.setOnTapPlaneGlbModel("gladiador.glb", new ArFragment.OnTapModelListener() {
                    @Override
                    public void onModelAdded(RenderableInstance renderableInstance) {
                    }

                    @Override
                    public void onModelError(Throwable exception) {
                    }
                });
            }
        });
        if (savedInstanceState == null) {
            if (Sceneform.isSupported(this)) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.arFragment, ArFragment.class, null)
                        .commit();
            }
        }
    }
}
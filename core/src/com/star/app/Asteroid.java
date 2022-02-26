package com.star.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static com.star.app.ScreenManager.SCREEN_HEIGHT;
import static com.star.app.ScreenManager.SCREEN_WIDTH;

public class Asteroid {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private float angle;

    public Asteroid() {
        this.texture=new Texture("asteroid.png");
        this.position = new Vector2(SCREEN_WIDTH, MathUtils.random(256, SCREEN_HEIGHT-256));
        this.velocity = new Vector2(MathUtils.random(-40, -20), MathUtils.random(-20,20));
        this.angle = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x , position.y , 128, 128,
                256, 256, 1, 1, angle, 0, 0, 256, 256,
                false, false);
    }

    public void update(float dt) {
        position.x += velocity.x * dt;
        position.y += velocity.y * dt;

        if (position.x < -256) {
            position.x = SCREEN_WIDTH + 256;
        }
        if (position.y<-256){
            position.y=SCREEN_HEIGHT+256;
        }if (position.y> SCREEN_HEIGHT+256){
            position.y=-256;
        }
    }
}

package com.company;

import dev.jabo.kree.*;
import dev.jabo.kree.Window;
import dev.jabo.kree.components.BoxCollider;
import dev.jabo.kree.components.MeshRenderer;
import dev.jabo.kree.components.PlayerMovement;
import dev.jabo.kree.components.SpriteRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Main {

    public static void main(String[] args) {
        Game game = new Game(new Window("MyGame", 1920, 1080));

        SceneManager.setScene(new MyScene(game));

        game.start();
    }

}
class MyScene extends Scene {

    private final GameObject gameObject = new GameObject(this, "Player");
    private final GameObject enemy = new GameObject(this, "Enemy");
    private final GameObject finish = new GameObject(this, "Finish");
    private final GameObject sad = new GameObject(this, "Start");



    public MyScene(Game game){
        super(game);
    }
    @Override
    public void Initialize() {
        gameObject.getTransform().setScale(new Vector2(50,50));
        gameObject.getTransform().setPosition(new Vector2(200, 300));
        gameObject.addComponent(new PlayerMovement(2.5f, PlayerMovement.WASD));
        Sprite a = new Sprite("/Ball.png");
        gameObject.addComponent(new SpriteRenderer(a));
        new BoxCollider();
        if (((BoxCollider)gameObject.getComponent("Box Collider"))
                .collidingWith((BoxCollider) gameObject.getComponent("Box Collider")))

        enemy.getTransform().setScale(new Vector2(30,30));
        enemy.getTransform().setPosition(new Vector2(200, 300));
        Sprite b = new Sprite("/B2.png");
        enemy.addComponent(new SpriteRenderer(b));
        
       /* finish.getTransform().setScale(new Vector2(400, 30));
        finish.getTransform().setPosition(new Vector2(200,40));
        Sprite f = new Sprite("/f.png");
        finish.addComponent(new SpriteRenderer(f));


        sad.getTransform().setScale(new Vector2(400, 30));
        sad.getTransform().setPosition(new Vector2(200,500));
        Sprite d = new Sprite("/d.png");
        sad.addComponent(new SpriteRenderer(d));*/
    }

    @Override
    public void Update() {

            enemy.getTransform().getPosition().addX(3);

    }

    @Override
    public void Render(Graphics graphics) {
        BufferedImage background = ImageLoader.loadImage("/kak.jpg");
        graphics.drawImage(background, 0, 0, null);
    }


}
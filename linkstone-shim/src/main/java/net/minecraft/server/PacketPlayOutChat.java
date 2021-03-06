package net.minecraft.server;

import com.flowpowered.network.Message;
import net.glowstone.linkstone.annotations.LClassfile;
import net.glowstone.linkstone.annotations.LConstructor;
import net.glowstone.linkstone.annotations.LField;
import net.glowstone.linkstone.annotations.LMethod;
import net.glowstone.net.message.play.game.ChatMessage;
import net.glowstone.util.TextMessage;
import net.md_5.bungee.api.chat.BaseComponent;

import static net.glowstone.linkstone.annotations.Version.V1_12_R1;

@LClassfile(version = V1_12_R1)
public class PacketPlayOutChat implements Packet<PacketListenerPlayOut> {
    @LField(version = V1_12_R1, name = "a")
    private IChatBaseComponent text;

    @LField(version = V1_12_R1, name = "b")
    private ChatMessageType messageType;

    /**
     * This field is preferred over {@link PacketPlayOutChat#messageType} if available.
     */
    @LField(version = V1_12_R1)
    public BaseComponent[] components;

    @LConstructor(version = V1_12_R1)
    public PacketPlayOutChat() {}

    @LConstructor(version = V1_12_R1)
    public PacketPlayOutChat(IChatBaseComponent text) {
        this.text = text;
        this.messageType = ChatMessageType.SYSTEM;
    }

    @LConstructor(version = V1_12_R1)
    public PacketPlayOutChat(IChatBaseComponent text, ChatMessageType messageType) {
        this.text = text;
        this.messageType = messageType;
    }

    @LMethod(version = V1_12_R1, name = "c")
    public ChatMessageType getMessageType() {
        return messageType;
    }

    @Override
    public Message toGlowMessage() {
        TextMessage text = components == null ?
                IChatBaseComponent.toGlowMessage(this.text) :
                IChatBaseComponent.toGlowMessage(this.components);

        return new ChatMessage(text, messageType.getId());
    }
}

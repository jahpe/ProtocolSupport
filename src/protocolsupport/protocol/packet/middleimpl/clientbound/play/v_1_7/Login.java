package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_1_7;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleLogin;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class Login extends MiddleLogin {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData(ProtocolVersion version) {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_LOGIN_ID, version);
		serializer.writeInt(playerEntityId);
		serializer.writeByte(gamemode);
		serializer.writeByte(dimension);
		serializer.writeByte(difficulty);
		serializer.writeByte(Math.min(maxplayers, 60));
		StringSerializer.writeString(serializer, version, leveltype);
		return RecyclableSingletonList.create(serializer);
	}

}

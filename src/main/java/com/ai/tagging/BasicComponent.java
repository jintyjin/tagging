package com.ai.tagging;

import com.ai.tagging.entity.Live;
import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.DeviceStatus;
import com.ai.tagging.entity.device.RtspUrl;
import com.ai.tagging.entity.member.Address;
import com.ai.tagging.entity.member.Grade;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.entity.member.MemberStatus;
import com.ai.tagging.repository.LiveRepository;
import com.ai.tagging.repository.device.DeviceRepository;
import com.ai.tagging.repository.device.RtspRepository;
import com.ai.tagging.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class BasicComponent {

    private final MemberRepository memberRepository;
    private final DeviceRepository deviceRepository;
    private final RtspRepository rtspRepository;
    private final LiveRepository liveRepository;

    @PostConstruct
    public void initSampleData() {
        Member member1 = new Member("유저1", "user1", "1234", "010-1234-5674", new Address("Seoul", "Daerim", "11111"), MemberStatus.JOINED, Grade.MEMBER);
        Member member2 = new Member("유저2", "user2", "3234", "010-1234-5673", new Address("Incheon", "Sentral", "11112"), MemberStatus.NORMAL, Grade.MEMBER);

        Device device1 = new Device("nvr01", "1234", 1, "장비1", "127.0.0.1", 8081, "00:00:0c:28:01", DeviceStatus.BROKEN);
        Device device2 = new Device("nvr02", "3234", 3, "장비3", "127.0.0.3", 8083, "00:00:0c:28:03", DeviceStatus.TURN_OFF);
        Device device3 = new Device("nvr03", "5234", 5, "장비5", "127.0.0.5", 8085, "00:00:0c:28:05", DeviceStatus.FIXING);
        Device device4 = new Device("nvr04", "7234", 7, "장비7", "127.0.0.7", 8087, "00:00:0c:28:07", DeviceStatus.TURN_ON);

        RtspUrl rtspUrl1 = new RtspUrl("rtsp://127.0.0.1/onvif-media", device1);
        RtspUrl rtspUrl2 = new RtspUrl("rtsp://127.0.0.3/onvif-media", device2);
        RtspUrl rtspUrl3 = new RtspUrl("rtsp://127.0.0.5/onvif-media", device3);
        RtspUrl rtspUrl4 = new RtspUrl("rtsp://127.0.0.7/onvif-media", device4);

        Live live1 = new Live(member1, device1);
        Live live2 = new Live(member2, device2);
        Live live3 = new Live(member1, device3);
        Live live4 = new Live(member2, device4);

        Long savedMemberId1 = memberRepository.save(member1);
        Long savedMemberId2 = memberRepository.save(member2);

        Device savedDevice1 = deviceRepository.save(device1);
        Device savedDevice2 = deviceRepository.save(device2);
        Device savedDevice3 = deviceRepository.save(device3);
        Device savedDevice4 = deviceRepository.save(device4);

        RtspUrl savedRtspUrl1 = rtspRepository.save(rtspUrl1);
        RtspUrl savedRtspUrl2 = rtspRepository.save(rtspUrl2);
        RtspUrl savedRtspUrl3 = rtspRepository.save(rtspUrl3);
        RtspUrl savedRtspUrl4 = rtspRepository.save(rtspUrl4);

        Live savedLive1 = liveRepository.save(live1);
        Live savedLive2 = liveRepository.save(live2);
        Live savedLive3 = liveRepository.save(live3);
        Live savedLive4 = liveRepository.save(live4);
    }
}

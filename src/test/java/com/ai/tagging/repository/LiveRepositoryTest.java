package com.ai.tagging.repository;

import com.ai.tagging.entity.Live;
import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.RtspUrl;
import com.ai.tagging.entity.member.Address;
import com.ai.tagging.entity.member.Grade;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.entity.member.MemberStatus;
import com.ai.tagging.repository.device.DeviceRepository;
import com.ai.tagging.repository.device.RtspRepository;
import com.ai.tagging.repository.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LiveRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    RtspRepository rtspRepository;
    @Autowired
    LiveRepository liveRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void live_test() {
        //given
        Member member1 = new Member("유저1", "user1", "1234", "010-1234-5674", new Address("Seoul", "Daerim", "11111"), MemberStatus.Normal, Grade.MEMBER);
        Member member2 = new Member("유저2", "user2", "3234", "010-1234-5673", new Address("Incheon", "Sentral", "11112"), MemberStatus.Normal, Grade.MEMBER);

        Device device1 = new Device("nvr01", "1234", 1, "장비1", "127.0.0.1", 8081, "00:00:0c:28:01");
        Device device2 = new Device("nvr02", "3234", 3, "장비3", "127.0.0.3", 8083, "00:00:0c:28:03");
        Device device3 = new Device("nvr03", "5234", 5, "장비5", "127.0.0.5", 8085, "00:00:0c:28:05");
        Device device4 = new Device("nvr04", "7234", 7, "장비7", "127.0.0.7", 8087, "00:00:0c:28:07");

        RtspUrl rtspUrl1 = new RtspUrl("rtsp://127.0.0.1/onvif-media", device1);
        RtspUrl rtspUrl2 = new RtspUrl("rtsp://127.0.0.3/onvif-media", device2);
        RtspUrl rtspUrl3 = new RtspUrl("rtsp://127.0.0.5/onvif-media", device3);
        RtspUrl rtspUrl4 = new RtspUrl("rtsp://127.0.0.7/onvif-media", device4);

        Live live1 = new Live(member1, device1);
        Live live2 = new Live(member2, device2);
        Live live3 = new Live(member1, device3);
        Live live4 = new Live(member2, device4);

        //when
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

        //then
        assertThat(member1.getId()).isEqualTo(savedMemberId1);
        assertThat(member2.getId()).isEqualTo(savedMemberId2);

        assertThat(device1.getId()).isEqualTo(savedDevice1.getId());
        assertThat(device2.getId()).isEqualTo(savedDevice2.getId());
        assertThat(device3.getId()).isEqualTo(savedDevice3.getId());
        assertThat(device4.getId()).isEqualTo(savedDevice4.getId());

        assertThat(rtspUrl1.getId()).isEqualTo(savedRtspUrl1.getId());
        assertThat(rtspUrl2.getId()).isEqualTo(savedRtspUrl2.getId());
        assertThat(rtspUrl3.getId()).isEqualTo(savedRtspUrl3.getId());
        assertThat(rtspUrl4.getId()).isEqualTo(savedRtspUrl4.getId());

        assertThat(live1.getId()).isEqualTo(savedLive1.getId());
        assertThat(live2.getId()).isEqualTo(savedLive2.getId());
        assertThat(live3.getId()).isEqualTo(savedLive3.getId());
        assertThat(live4.getId()).isEqualTo(savedLive4.getId());

        assertThat(member1.getLiveList().size()).isEqualTo(2);
        assertThat(member2.getLiveList().size()).isEqualTo(2);

        member1.getLiveList().stream()
                .forEach(live -> {
                    System.out.println("member1.live.device = " + live.getDevice().getId());
                });

        member2.getLiveList().stream()
                .forEach(live -> {
                    System.out.println("member2.live.device = " + live.getDevice().getId());
                });

    }
}
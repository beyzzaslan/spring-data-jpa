package com.beyzaslan.services.impl;

import com.beyzaslan.dto.DtoHome;
import com.beyzaslan.dto.DtoRoom;
import com.beyzaslan.entities.Home;
import com.beyzaslan.entities.Room;
import com.beyzaslan.repository.HomeRepository;
import com.beyzaslan.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {


    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        List<Room> dbRooms = optional.get().getRoom();//room u alıyo
        Home dbHome = optional.get();
        BeanUtils.copyProperties(dbHome, dtoHome);

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;

    }
}

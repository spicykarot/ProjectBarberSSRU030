package com.man.barber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrBarberTeam;
import com.man.barber.model.BarberTeamModel;
import com.man.barber.model.UserModel;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.BarberTeamRepository;
import com.man.barber.repository.UserRepository;

@Service
public class BarberTeamService {
	
	@Autowired
	private BarberTeamRepository barberTeamRepository;
	@Autowired
	private BarberShopRepository barberShopRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<TrBarberTeam> findUserAll() {
        return barberTeamRepository.findAll();
    }

    public TrBarberTeam findUserById(long id) {
        return barberTeamRepository.findById(id).get();
    }
    
    public Boolean addBarberTeam(BarberTeamModel barberTeamModel) {
		TrBarberTeam barberteamTb = new TrBarberTeam();
		Boolean result = false;
		try {
			
			MsBarberShop barbershopTb = barberShopRepository.getById(barberTeamModel.getBarbershopId().getId());
			MsUser userTb = userRepository.getById(barberTeamModel.getHairdresserId().getId());
			
			barberteamTb.setBarbershopId(barbershopTb);
			barberteamTb.setHairdresserId(userTb);

			barberteamTb = barberTeamRepository.save(barberteamTb);

			if (barberteamTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
}

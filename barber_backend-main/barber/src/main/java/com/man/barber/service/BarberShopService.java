package com.man.barber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrBarberService;
import com.man.barber.entity.TrBarberTeam;
import com.man.barber.model.BarberServiceModel;
import com.man.barber.model.BarberShopModel;
import com.man.barber.model.BarberTeamModel;
import com.man.barber.model.UserModel;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.UserRepository;

@Service
public class BarberShopService {

	@Autowired
	private BarberShopRepository barberShopRepository;
	@Autowired
	private UserRepository userRepository;

	public List<MsBarberShop> findUserAll() {
		return barberShopRepository.findAll();
	}

	public MsBarberShop findUserById(long id) {
		return barberShopRepository.findById(id).get();
	}

	public Page<BarberShopModel> getAllBarberShopModelFilterWithPaggingAndSearching(String name, Integer pageNo,
			Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return barberShopRepository.findAllFilterWithPagingAndSearching(name, paging);
	}

	public BarberShopModel getBarberShopModelById(Long barbershopId) {
		BarberShopModel barbershopModel = new BarberShopModel();

		MsBarberShop barberTb = barberShopRepository.getById(barbershopId);
		barbershopModel.setId(barberTb.getId());
		barbershopModel.setName(barberTb.getName());
		barbershopModel.setAddress(barberTb.getAddress());
		barbershopModel.setTel(barberTb.getTel());
		barbershopModel.setImage(barberTb.getImage());
		barbershopModel.setBarberOwnerId(barberTb.getBarberOwnerId().getId());

		List<BarberServiceModel> barberServiceModelList = new ArrayList<BarberServiceModel>();

		for (TrBarberService barberserviceTb : barberTb.getBarberserviceList()) {
			BarberServiceModel barberserviceModel = new BarberServiceModel();
			barberserviceModel.setId(barberserviceTb.getId());
			barberserviceModel.setName(barberserviceTb.getName());
			barberserviceModel.setPrice(barberserviceTb.getPrice());
			barberserviceModel.setBarbershopId(barberserviceTb.getBarbershopId().getId());

			barberServiceModelList.add(barberserviceModel);

		}

		barbershopModel.setBarberServiceList(barberServiceModelList);

		List<BarberTeamModel> barberTeamModelList = new ArrayList<BarberTeamModel>();
		
		System.out.println("count : " + barberTb.getBarberteam().size());
		
		for (TrBarberTeam barberteamTb : barberTb.getBarberteam()) {
			System.out.println("countOfBarberTeam");
			BarberTeamModel barberTeamModel = new BarberTeamModel();
			barberTeamModel.setId(barberteamTb.getId());
			
			MsUser userTb = barberteamTb.getHairdresserId();
			UserModel hairdresser = new UserModel();
			
			hairdresser.setId(userTb.getId());
			hairdresser.setFirstName(userTb.getFirstName());
			hairdresser.setLastName(userTb.getLastName());
			hairdresser.setEmail(userTb.getEmail());
			hairdresser.setPassword(userTb.getPassword());
			hairdresser.setUser_type(userTb.getUser_type());
			barberTeamModel.setHairdresserId(hairdresser);
			
			barberTeamModelList.add(barberTeamModel);
		}
		
		barbershopModel.setBarberTeamList(barberTeamModelList);
		return barbershopModel;

	}

	public Boolean addBarberShop(BarberShopModel barberShopModel) {
		MsBarberShop barbershopTb = new MsBarberShop();
		Boolean result = false;
		try {
			MsUser userTb = userRepository.getById(barberShopModel.getBarberOwnerId());

			barbershopTb.setName(barberShopModel.getName());
			barbershopTb.setAddress(barberShopModel.getAddress());
			barbershopTb.setTel(barberShopModel.getTel());
			barbershopTb.setImage(barberShopModel.getImage());
			barbershopTb.setBarberOwnerId(userTb);

			List<TrBarberService> barberServiceTbList = new ArrayList<TrBarberService>();
			for (BarberServiceModel barberserviceModel : barberShopModel.getBarberServiceList()) {
				System.out.println("getName: " + barberserviceModel.getName());
				System.out.println("getPrice: " + barberserviceModel.getPrice());
				TrBarberService barberServiceTb = new TrBarberService();
				barberServiceTb.setName(barberserviceModel.getName());
				barberServiceTb.setPrice(barberserviceModel.getPrice());
				barberServiceTb.setBarbershopId(barbershopTb);
				barberServiceTbList.add(barberServiceTb);
			}
			barbershopTb.setBarberserviceList(barberServiceTbList);
			
//			List<TrBarberTeam> barberTeamTbList = new ArrayList<TrBarberTeam>();
//			for (BarberTeamModel barberteamModel : barberShopModel.getBarberTeamList()) {
//				System.out.println("getHairdresserId : " + barberteamModel.getHairdresserId().getId());
//				TrBarberTeam barberTeamTb = new TrBarberTeam();
//				barberTeamTb.setBarbershopId(barbershopTb);
//				MsUser hairdresserTb = userRepository.getById(barberteamModel.getHairdresserId().getId());
//				barberTeamTb.setHairdresserId(hairdresserTb);
//				barberTeamTbList.add(barberTeamTb);
//			}
//			barbershopTb.setBarberteam(barberTeamTbList);
			
			barberShopRepository.save(barbershopTb);

			if (barbershopTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateBarberShop(BarberShopModel barberShopModel) {
		Boolean result = false;
		try {
			MsBarberShop barbershopTb = barberShopRepository.getById(barberShopModel.getId());
			if (barbershopTb != null) {
				if (!ObjectUtils.isEmpty(barberShopModel.getName())) {
					barbershopTb.setName(barberShopModel.getName());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getAddress())) {
					barbershopTb.setAddress(barberShopModel.getAddress());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getTel())) {
					barbershopTb.setTel(barberShopModel.getTel());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getImage())) {
					barbershopTb.setImage(barberShopModel.getImage());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getBarberOwnerId())) {
					MsUser barberOwner = userRepository.getById(barberShopModel.getBarberOwnerId());
					barbershopTb.setBarberOwnerId(barberOwner);
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getBarberServiceList())) {
					List<TrBarberService> barberServiceTbList = new ArrayList<TrBarberService>();
					for (BarberServiceModel barberserviceModel : barberShopModel.getBarberServiceList()) {
						TrBarberService barberServiceTb = new TrBarberService();
						barberServiceTb.setId(barberserviceModel.getId());
						barberServiceTb.setName(barberserviceModel.getName());
						barberServiceTb.setPrice(barberserviceModel.getPrice());
						barberServiceTb.setBarbershopId(barbershopTb);
						barberServiceTbList.add(barberServiceTb);
					}
					barbershopTb.setBarberserviceList(barberServiceTbList);
				}
				barbershopTb = barberShopRepository.save(barbershopTb);
				if (barbershopTb != null) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

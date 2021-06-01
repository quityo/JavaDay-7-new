package kodlamaio.hrms.core.adapter;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.Concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CheckMernisService {

    @Override
    public boolean checkIfRealTcNo(JobSeeker jobSeeker) {
        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean serviceResult=false;

        try {

            serviceResult = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalyIdentity()),
            		jobSeeker.getFirstName().toUpperCase(),
            		jobSeeker.getLastName().toUpperCase(),
            		jobSeeker.getBirthDate());

        } catch (Exception e) {

            System.out.println("Not a valid person");
        }

       return serviceResult; 
    }

	

}
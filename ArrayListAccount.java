package assignment;

import java.util.*;

public class ArrayListAccount {

	public static void main(String[] args) {
		
		List<account> lt = new ArrayList<>();
		
		account ac1 = new account("Benjamin Pavard", 1201, 2000);
		lt.add(ac1);
		
		account ac2 = new account("Lucas Hernandez", 1351, 3810);
		lt.add(ac2);
		
		lt.add(new account("Niko Mazaroui", 5431, 2230));
		lt.add(new account("Kingsley Koman", 9761, 4495));
		
		System.out.println(lt);
		System.out.println(lt.size());
		
		lt.remove(2);
		System.out.println(lt);
		System.out.println(lt.size());
		
		boolean isIt = lt.contains(ac1);
		System.out.println(isIt + " this element is present here!!!");
		
		account ac3 = new account("Sadio Mane", 5541, 2989);
		
		lt.set(2, ac3);
		System.out.println(lt);
		System.out.println(lt.size());
	}

}

---------------------------------------------------------------------------------------------------------------------------------------------------------------

    exportQuery(query, variables?, fileName: string = null, ignorePropertyPath = false, queryType: string = null): Promise<any> {
        const timeInterval = 5000;
        const timeoutInterval = 900000;
        var counter = 0;
        const url = `${environment.adminUrl}/export/storefile?ignorePropertyPath=${ignorePropertyPath}&fname=${fileName}`;
        const body = {
            variables,
            operationName: queryType,
            query: print(query)
        };
        const toast = this.toastr.download(this.resources['ExportingList']);
        return this.http.post<any>(url, body).pipe(
            map(response => {
                const interval = setInterval(() => {
                    counter = counter + timeInterval;
                    const url = `${environment.adminUrl}/export/checks3object?fileName=${response.fileName}`;
                    const body = {};
                    return this.http.get<any>(url, body).pipe(
                        map(res => {
                            if (res.isExist) {
                                clearInterval(interval);
                                this.downloadExcel(res, "", toast);
                            }
                            if (counter == timeoutInterval) {
                                clearInterval(interval)
                                this.handleError(null, toast);
                            }
                        }),
                        catchError(error => {
                            clearInterval(interval);
                            return this.handleError(error, toast);
                        }),
                        take(1)
                    ).toPromise();
                }, timeInterval);
            }),
            catchError(error => this.handleError(error, toast)),
            take(1)
        ).toPromise();
    }
